package com.example.resttemplatetest.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public ResponseEntity<String> fetchData (@RequestBody String requestData){
        String responseData = restAPITestService.fetchData(requestData);
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }
}
