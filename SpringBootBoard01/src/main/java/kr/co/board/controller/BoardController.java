package kr.co.board.controller;

import kr.co.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;


    @GetMapping("/home")
    public String home(){

        return "home";
    }
    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping()
    public String save(){
        return "";
    }

}
