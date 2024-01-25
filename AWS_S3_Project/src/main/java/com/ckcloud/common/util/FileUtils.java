package com.ckcloud.common.util;

import com.ckcloud.common.domain.FileRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component  // 개발자가 직접 정의한 클래스를 빈으로 등록.
public class FileUtils {

    private final String uploadPath = Paths.get("E:", "upload", "temp", "bootS3").toString();

    /**
     * 다중 파일 업로드
     * @param multipartFiles - 파일 객체 List
     * @return DB에 저장할 파일 정보 List
     */
    public List<FileRequest> uploadFiles(final List<MultipartFile> multipartFiles){
        List<FileRequest> files = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles){
            if (multipartFile.isEmpty()){
                continue;
            }
            files.add(uploadFile(multipartFile));
        }
        return files;
    }


    /**
     * 단일 파일 업로드
     * @param multipartFile - 파일 객체
     * @return DB에 저장할 파일 정보
     */
    public FileRequest uploadFile(final MultipartFile multipartFile){
        if (multipartFile.isEmpty()){
            return null ;
        }

        String savedName = generateSaveFileName(multipartFile.getOriginalFilename());
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")).toString();
        String uploadPath = getUploadPath(today) + File.separator + savedName;
        File uploadFile = new File(uploadPath);

        try{
            multipartFile.transferTo(uploadFile);
        }catch(IOException e){
            throw new RuntimeException(e);
        }

        return FileRequest.builder()
                .originalName(multipartFile.getOriginalFilename())
                .savedName(savedName)
                .originalPath(uploadPath)
                .savedPath(uploadPath)
                .build();
    }

    /**
     * 저장 파일명 생성
     * @param filename 원본 파일명
     * @return 디스크에 저장할 파일명
     */
    private String generateSaveFileName(final String filename){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String extension = StringUtils.getFilenameExtension(filename);
        return uuid + "." + extension;
    }


    /**
     * 업로드 경로 반환
     * @return 업로드 경로
     */
    private String getUploadPath(){
        return makeDirectories(uploadPath);
    }

    /**
     * 업로드 경로 반환
     * @param addPath - 추가 경로
     * @return 업로드 경로
     */
    private String getUploadPath(final String addPath){
        return makeDirectories(uploadPath + File.separator + addPath);
    }

    private String makeDirectories(final String path){
        File dir = new File(path);
        if (dir.exists() == false){
            dir.mkdirs();
        }
        return dir.getPath();
    }

}
