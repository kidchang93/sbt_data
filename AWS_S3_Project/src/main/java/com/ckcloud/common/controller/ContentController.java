package com.ckcloud.common.controller;

import com.ckcloud.common.domain.*;
import com.ckcloud.common.dto.SearchDTO;
import com.ckcloud.common.paging.Pagination;
import com.ckcloud.common.service.ContentService;
import com.ckcloud.common.service.FileService;
import com.ckcloud.common.util.FileUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        MessageDTO message = new MessageDTO("게시글 생성이 완료되었습니다.", "list", RequestMethod.GET, null);
        return showMessageAndRedirect(message,model);
    }

    // 게시글 리스트 페이지
    /*@GetMapping("/list")
    public String openContentList(@ModelAttribute("params") final SearchDTO params, Model model) {
        PagingResponse<ContentResponse> contents = contentService.findAllContent(params);
        log.info("==== 원래 contents 값 ===="+contents);
        log.info("==== SEARCHDTO params 값 ===="+params);

        model.addAttribute("contentList",contents);
        return "list";
    }*/
    @GetMapping("/list")
    public String openContentList(final SearchDTO params, Model model) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        PagingResponse<ContentResponse> contents = contentService.findAllContent(params);
        log.info("==== 원래 Contents 값 ===="+contents);
        /*String jsonContents = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(contents);
        log.info("==== 제이슨 jsonContents 값 ===="+jsonContents);*/

        Pagination pagination = contents.getPagination();
        String jsonPagination = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pagination);
        model.addAttribute("getPagination",jsonPagination);

        String jsonParams = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(params);
        model.addAttribute("params",jsonParams);

        log.info("==== 제이슨 jsonPagination 값 ===="+jsonPagination);


        log.info("==== params 값 ===="+params);

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
    public String updateContentComplete(@ModelAttribute ContentResponse contentResponse, Model model){
        log.info("업데이트 완료");
        contentService.updateContent(contentResponse);
        MessageDTO message = new MessageDTO("게시글 수정이 완료되었습니다.", "list", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    @PostMapping("/delete")
    public String deleteContent(@RequestParam("id") int id, Model model) {
        log.info("삭제 성공");
        MessageDTO message = new MessageDTO("게시글 삭제가 완료되었습니다.", "list", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);

    }

// 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDTO params, Model model){
        model.addAttribute("params",params);
        return "/common/messageRedirect";
    }
}
