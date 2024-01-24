package kr.co.chunjae.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorControllerTemp implements ErrorController {

    /** 스프링에서 제공하는 기본적인 에러 페이지 컨트롤러 */
    @GetMapping("/error")
    public String handleError() throws Exception{
        return "error/error";
    }
}
