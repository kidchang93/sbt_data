package com.ckcloud.common.service;

import com.amazonaws.services.s3.AmazonS3;
import com.ckcloud.common.domain.FileRequest;
import com.ckcloud.common.mapper.FileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class FileService {

    @Value("${application.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    @Autowired
    private FileMapper fileMapper;


    /**
     * S3에서 byte 코드로 변환해줄 메서드
     * @param uploadFiles;
     * @return convertedFiles;
     */
    private File convertMultiPartFileToFile(MultipartFile uploadFiles) {
        File convertedFile = new File(uploadFiles.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(uploadFiles.getBytes());

            log.info("=== fos === " + fos);
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        log.info("=== convertedFile ===" + convertedFile);
        return convertedFile;
    }

    /**
     * 게시글 번호(contentId)와 파일 정보를 전달받아 업로드 된 파일 정보를
     * 테이블에 저장하는 역할. 만약 게시글을 저장(Insert or Update) 하는 시점에
     * 파일이 없다면 로직을 종료하고 파일이 있으면 모든 요청 객체에 게시글 번호(contentId)를 세팅한 후
     * 테이블에 파일정보를 저장한다.
     * @param contentId
     * @param files
     */
    @Transactional
    public void saveFiles(final int contentId , final List<FileRequest> files){
        if (CollectionUtils.isEmpty(files)){
            return;
        }
        for (FileRequest file : files){
            file.setContentId(contentId);
        }
        fileMapper.saveAll(files);
    }
}
