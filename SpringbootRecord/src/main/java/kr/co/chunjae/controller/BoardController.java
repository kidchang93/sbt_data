package kr.co.chunjae.controller;

import kr.co.chunjae.service.BoardService;
import kr.co.chunjae.service.BoardServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

   private final BoardService boardService;



    @GetMapping("/home")
    public String home(){

        return "home";
    }

    @GetMapping("list")
    @ResponseBody
    public String boardList(){

        List<Map<String,String>> list = new ArrayList<>();
        list = boardService.FindAllList();

        for (Map<String,String> map : list){
            System.out.println(map.get("id"));
            System.out.println(map.get("TITLE"));
            System.out.println(map.get("CONTENTS"));
            System.out.println(map.get("REGDATE"));
        }
        return "--";
    }

}
