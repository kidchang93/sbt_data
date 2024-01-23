package com.ckcloud.controller;

import com.ckcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class StorageController {

    @Autowired
    private StorageService service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file){

        return new ResponseEntity<>(service.uploadFile(file), HttpStatus.OK);

    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable("fileName") String fileName){
        byte[] data = service.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type" , "application/octet-steam")
                .header("Content-disposition","attachment; filename = \"" + fileName + "\"")
                .body(resource);

    }
    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(String fileName){
        return new ResponseEntity<>(service.deleteFile(fileName),HttpStatus.OK);

    }
}
