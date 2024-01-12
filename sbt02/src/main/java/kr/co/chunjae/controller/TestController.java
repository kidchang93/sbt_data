package kr.co.chunjae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
  @RequestMapping(value="/")
  public String home(Model model){
    System.out.println("ddd");
    model.addAttribute("message","HelloCK");
    return"hello";
  }
}
