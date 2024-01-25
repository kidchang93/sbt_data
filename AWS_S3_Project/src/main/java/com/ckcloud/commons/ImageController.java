package com.ckcloud.commons;

import com.ckcloud.common.domain.FileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boot")
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/main")
    public String hello(){
        return "upload";
    }

/*    @PostMapping("/upload")
    public String upload(@RequestParam("uploadFile")MultipartFile[] uploadFiles, Model model){
        List<FileDTO> files = imageService.upload(uploadFiles);
        model.addAttribute("fileList",files);
        return "results";
    }*/

    @GetMapping("/download")
    public ResponseEntity<?> download(@ModelAttribute FileRequest dto) throws IOException {
        return imageService.download(dto);
    }

    @GetMapping("/display")
    public ResponseEntity<?> display(@RequestParam("filename") String filename) {
        return imageService.display(filename);
    }
}
