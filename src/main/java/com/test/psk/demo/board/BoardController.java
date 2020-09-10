package com.test.psk.demo.board;

import com.test.psk.demo.common.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.test.psk.demo.common.Global.Return.resultJson;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/api/selectList")
    public String selectList() {
        return resultJson(boardService.selectList(new ParamBoardVO()));
    }

    @GetMapping("/api/get")
    public String get(ParamBoardVO param) {
        return resultJson(boardService.get(param));
    }

    @PostMapping("/api/create")
    public String create(@RequestBody ParamBoardVO param) {
        return resultJson(boardService.create(param));
    }

    @PostMapping("/api/update")
    public String update(@RequestBody ParamBoardVO param) {
        return resultJson(boardService.update(param));
    }

    @PostMapping("/api/delete")
    public String delete(@RequestBody ParamBoardVO param) {
        return resultJson(boardService.delete(param));
    }

}
