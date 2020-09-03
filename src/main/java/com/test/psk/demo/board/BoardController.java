package com.test.psk.demo.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @Autowired
    //private BoardService boardService;
    private  BoardDAO boardDAO;

    @GetMapping("/api/selectList")
    public String api() {
        //return boardService.selectList(new ParamBoardVO()).toString();
        return boardDAO.selectList().toString();
    }

}
