package com.example.testprogect.controller;

import com.example.testprogect.dto.MemberDTO;
import com.example.testprogect.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest-template")
public class RestTemplateController {

    RestTemplateService restTemplateService;

    @Autowired
    public RestTemplateController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping(value = "/ck-hub")
    public String getCKHub() {
        return restTemplateService.getCKHub();
    }

    @GetMapping(value = "/name")
    public String getName() {
        return restTemplateService.getName();
    }

    @GetMapping(value = "/name2")
    public String getName2() {
        return restTemplateService.getName2();
    }

    @PostMapping(value = "/dto")
    public ResponseEntity<MemberDTO> postDTO() {
        return restTemplateService.postDTO();
    }

    @PostMapping(value = "/add-header")
    public ResponseEntity<MemberDTO> addHeader() {
        return restTemplateService.addHeader();
    }
}
