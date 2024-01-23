package kr.co.chunjae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class LoginController {

    @GetMapping("login")
    public String loginForm(){
        return "login";
    }

}
