package com.ckcloud.commons;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.springframework.http.ResponseEntity.status;

@Service
public class ImageService {

    String originalPath = "E:\\upload\\temp\\bootS3";

    public List<FileDTO> upload(MultipartFile[] uploadFiles){
        List<FileDTO> files = new ArrayList<>();

        Arrays.stream(uploadFiles).forEach(multipartFile -> {
            FileDTO file = new FileDTO(multipartFile.getOriginalFilename(), multipartFile.getContentType());
            files.add(file);

            File newFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));

            try{
                multipartFile.transferTo(newFile);
            }catch(IOException e){
                e.printStackTrace();
            }
        });

        return files;
    }

    public ResponseEntity<?> download(FileDTO dto) throws IOException{

        Path path = Paths.get(originalPath + dto.getOriginalName());
        String contentType = Files.probeContentType(path);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDisposition(
                ContentDisposition.builder("attachment")
                        .filename(dto.getOriginalName(), StandardCharsets.UTF_8)
                        .build()
        );
        httpHeaders.add(HttpHeaders.CONTENT_TYPE,contentType);

        Resource resource = new InputStreamResource(Files.newInputStream(path));
        return new ResponseEntity<>(resource,httpHeaders, HttpStatus.OK);
    }

    public ResponseEntity<?> display(String filename) {
        String path = originalPath + filename;
        Resource resource = new FileSystemResource(path);

        if (!resource.exists()){
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        try{
            Path filepath = Paths.get(path);
            httpHeaders.add("Content-Type",Files.probeContentType(filepath));
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(resource,httpHeaders,HttpStatus.OK);
    }
}
