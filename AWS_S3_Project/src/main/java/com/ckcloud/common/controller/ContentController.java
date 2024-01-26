package com.ckcloud.common.controller;

import com.ckcloud.common.domain.ContentRequest;
import com.ckcloud.common.domain.ContentResponse;
import com.ckcloud.common.domain.FileRequest;
import com.ckcloud.common.service.ContentService;
import com.ckcloud.common.service.FileService;
import com.ckcloud.common.util.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/content")
@RequiredArgsConstructor
@Slf4j
public class ContentController {


    private final ContentService contentService;
    private final FileService fileService;
    private final FileUtils fileUtils;

    // 게시글 작성 페이지
    @GetMapping("/write")
    public String openContentWrite(@RequestParam(value = "id", required = false) Integer id , Model model){
        if (id != null) {
            ContentResponse content = contentService.findContentById(id);
            model.addAttribute("content",content);
        }

        return "write";
    }

    // 신규 게시글 생성
    @PostMapping("/save")
    public String save(final ContentRequest params, Model model){
        log.info("게시글 등록");
        int id = contentService.saveContent(params);
        /*List<FileRequest> files = fileUtils.uploadFiles(params.getFiles());
        fileService.saveFiles(id,files);*/
        System.out.println(id);
        return "redirect:/content/list";
    }

    // 게시글 리스트 페이지
    @GetMapping("/list")
    public String openContentList(Model model){
        List<ContentResponse> contents = contentService.findAllContent(model);
        model.addAttribute("contentList",contents);
        return "list";
    }

    // 게시물 상세 정보 조회
    @GetMapping("/view")
    public String openContentView(@RequestParam final int id , Model model){
        ContentResponse contentResponse = contentService.findContentById(id);
        model.addAttribute("content",contentResponse);
        return "view";
    }

    // 게시물 수정 화면 출력
    @GetMapping("/update")
    public String updateContent(@RequestParam("id") int id ,Model model){
        log.info("업데이트 도착");
        ContentResponse contentReponse = contentService.findContentById(id);
        model.addAttribute("contents",contentReponse);
        return "update";
    }

    // 게시물 수정 값 입력
    @PostMapping("/update")
    public String updateContentComplete(@ModelAttribute ContentResponse contentResponse){
        log.info("업데이트 완료");
        contentService.updateContent(contentResponse);
        log.info("ID~!!!##$%^^@^==!!!!" +contentResponse.getId());
        return "redirect:/content/list";
    }

    @PostMapping("/delete")
    public String deleteContent(@RequestParam("id") int id) {
        log.info("삭제 성공");
        contentService.deleteContent(id);
        return "redirect:/content/list";
    }

}
