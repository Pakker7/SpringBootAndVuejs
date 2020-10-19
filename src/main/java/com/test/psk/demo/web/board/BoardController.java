package com.test.psk.demo.web.board;

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
    private BoardService boardService;

    private BoardRepository boardRepository; //생성자로 Bean 객체를 받도록 하면 @Autowired와 동일한 효과를 볼 수 있다 --> ..??
                                                // 원래 @Autowired는 비권장방식이라고함..;;

    @PostMapping("/api/test/jpa/dbInsert")
    public void jpaInsert(@RequestBody BoardRequestDto dto){
        boardRepository.save(dto.toEntity());
    }

    @GetMapping("/api/selectList")
    public String selectList() {
        return Global.Return.resultJson(boardService.selectList(new ParamBoardVO()));
    }

    @GetMapping("/api/get")
    public String get(ParamBoardVO param) {
        return Global.Return.resultJson(boardService.get(param));
    }

    @PostMapping("/api/create")
    public String create(@RequestBody ParamBoardVO param) {
        return Global.Return.resultJson(boardService.create(param));
    }

    @PostMapping("/api/update")
    public String update(@RequestBody ParamBoardVO param) {
        return Global.Return.resultJson(boardService.update(param));
    }

    @PostMapping("/api/delete")
    public String delete(@RequestBody ParamBoardVO param) {
        return Global.Return.resultJson(boardService.delete(param));
    }

}
