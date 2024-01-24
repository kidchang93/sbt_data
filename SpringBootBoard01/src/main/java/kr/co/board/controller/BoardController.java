package kr.co.board.controller;

import kr.co.board.domain.BoardDTO;
import kr.co.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @PostMapping("/save")
    public String save(){


        try {

            // 예외 발생

            Exception ex = new Exception();

            throw ex;

        } catch(Exception e) {
            e.getMessage();
            System.out.println("Exception");

        }
        return "save";
    }


}
