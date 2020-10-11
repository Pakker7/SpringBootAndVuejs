package com.test.psk.demo.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.test.psk.demo.common.Global.Return.resultJson;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/api/selectList")
    public String api() {
        return resultJson(boardService.selectList(new ParamBoardVO()));
    }

}
