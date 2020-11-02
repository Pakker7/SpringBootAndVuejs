package com.test.psk.demo.domain;

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

    @PostMapping("/api/save")
    public Long save(@RequestBody BoardRequestDto requestDto){
        return boardService.save(requestDto);
    }

    @PutMapping("/api/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto boardRequestDto){
        return boardService.update(id,boardRequestDto);
    }

    @GetMapping("/api/board/{id}")
    public BoardResponseDto findById (@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto){
        return boardService.findById(id);
    }
}
