package com.test.psk.board.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/selectList")
    public Object selectList(ParamBoardVO param){
        return boardService.selectList(param);
    }
}
