package com.test.psk.demo.board;

import com.test.psk.demo.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/api/selectList")
    public String tddddst() {
        return boardService.selectList(new ParamBoardVO());
    }

}
