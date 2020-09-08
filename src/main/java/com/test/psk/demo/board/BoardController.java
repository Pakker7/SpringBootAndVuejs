package com.test.psk.demo.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.test.psk.demo.common.Global.Return.resultJson;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/api/selectList")
    public String selectList() {
        return resultJson(boardService.selectList(new ParamBoardVO()));
    }

    @PostMapping("/api/create")
    public String create(ParamBoardVO param) {
        return resultJson(boardService.create(param));
    }

    @PostMapping("/api/update")
    public String update(ParamBoardVO param) {
        return resultJson(boardService.update(param));
    }

    @PostMapping("/api/delete")
    public String delete(ParamBoardVO param) {
        return resultJson(boardService.delete(param));
    }

}
