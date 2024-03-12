package com.example.resttemplatetest.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/")
public class RestAPITestController {

    private final RestAPITestService restAPITestService;
    @GetMapping("/")
    public String getTestPage(){
        return "test";
    }

    @PostMapping("/testPost")
    public String postTestPage(@ModelAttribute("dto") RestAPITestDTO restAPITestDTO, Model model){
        log.info(restAPITestDTO);

        List dtoList = restAPITestService.testPage(restAPITestDTO);
        model.addAttribute("dtoList",dtoList);

        return "postPage";
    }
}
