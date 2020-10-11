package com.test.psk.demo.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.test.psk.demo.common.Global.Return.resultJson;

@RestController
public class BoardController {
//TODO 롬북이 왜 안되는지.. 적용하기..
//TODO post는 @RequetBody 있어야만 작동하는데.. 이거없어도 작동 하게 하기
//TODO Dao interface Mapper로 적용하기

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
