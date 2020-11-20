package com.test.psk.demo.domain;

import com.test.psk.demo.web.common.Global;
import com.test.psk.demo.web.common.annotation.Get;
import com.test.psk.demo.web.common.annotation.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;// 원래 @Autowired는 비권장방식이라고함..;;
    // 이렇게 생성자로 bean 주입이 가능한데 @RequiredArgsConstructor이거를 꼭 붙여 주어야 함

//    @PostMapping("/api/test/jpa/dbInsert")
//    public void jpaInsert(@RequestBody BoardRequestDto dto){
//        boardRepository.save(dto.toEntity());
//    }

    @Post("/api/save")
    public String save(@RequestBody BoardRequestDto requestDto){
        return Global.Return.resultJson(boardService.save(requestDto));
    }

    @Get("/api/selectList")
    public String selectList(@RequestBody BoardRequestDto requestDto){
        return Global.Return.resultJson(boardService.findAllDesc());
    }

    @PutMapping("/api/board/{id}")
    public String update(@PathVariable Long no, @RequestBody BoardUpdateRequestDto boardRequestDto){
        return Global.Return.resultJson(boardService.update(no,boardRequestDto));
    }

    @Get("/api/board/{no}")
    public String findById (@PathVariable Long no){
        return Global.Return.resultJson(boardService.findById(no));
    }
}
