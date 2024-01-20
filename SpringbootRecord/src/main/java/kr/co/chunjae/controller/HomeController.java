package kr.co.chunjae.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

  @RequestMapping(value="/")
  public String home(){
    System.out.println("홈실행");
    return"home";
  }

}
