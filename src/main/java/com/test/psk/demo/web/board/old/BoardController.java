package com.test.psk.demo.web.board.old;

import com.test.psk.demo.web.common.Global;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BoardController {
//TODO post는 @RequetBody 있어야만 작동하는데.. 이거없어도 작동 하는건가?
//TODO Dao interface Mapper로 적용하기 -> jpa 로 적용

    @Autowired
    private BoardServiceOld boardServiceOld;

//    @GetMapping("/api/selectList")
//    public String selectList() {
//        return Global.Return.resultJson(boardServiceOld.selectList(new ParamBoardVO()));
//    }
//
//    @GetMapping("/api/get")
//    public String get(ParamBoardVO param) {
//        return Global.Return.resultJson(boardServiceOld.get(param));
//    }
//
//    @PostMapping("/api/create")
//    public String create(@RequestBody ParamBoardVO param) {
//        return Global.Return.resultJson(boardServiceOld.create(param));
//    }
//
//    @PostMapping("/api/update")
//    public String update(@RequestBody ParamBoardVO param) {
//        return Global.Return.resultJson(boardServiceOld.update(param));
//    }
//
//    @PostMapping("/api/delete")
//    public String delete(@RequestBody ParamBoardVO param) {
//        return Global.Return.resultJson(boardServiceOld.delete(param));
//    }

}
