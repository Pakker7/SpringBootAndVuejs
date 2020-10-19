package com.test.psk.demo;

import com.test.psk.demo.web.board.BoardRepository;
import com.test.psk.demo.web.board.BoardVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void ekek(){
        //given
        BoardVO boardVO = BoardVO.builder()
                .title("title")
                .contents("contents")
                .writer("writer")
                .build();

        //when
        BoardVO vo =  boardRepository.save(boardVO);

        //then
        System.out.println(vo.toString());
    }

}
