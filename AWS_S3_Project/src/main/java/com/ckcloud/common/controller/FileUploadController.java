package com.ckcloud.common.controller;

import com.ckcloud.common.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/files")
@RequiredArgsConstructor
@Slf4j
public class FileUploadController {

    /* 의존성 주입 */
    private final FileService fileService;

    @GetMapping("/upload")
    public String uploadForm(){
        return "save";
    }

/*    @PostMapping("/upload")
    public @ResponseBody ResponseEntity<?> fileUpload(@RequestParam("uploadFile")MultipartFile[] files , Model model){
        log.info("포스트 업로드 입니다.");
        return new ResponseEntity<>(fileService.saveAll(files), HttpStatus.OK);
    }*/






}
