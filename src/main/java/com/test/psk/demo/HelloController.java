package com.test.psk.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.psk.board.board.BoardDAO;
import com.test.psk.board.board.BoardVO;
import com.test.psk.board.board.ParamBoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private BoardDAO boardDAO;

    @GetMapping("/hello")
    public String test() {

        List<BoardVO> board = boardDAO.selectList(new ParamBoardVO());
        try {
            String boardJson = new ObjectMapper().writeValueAsString(board);

            System.out.println("=========================");
            System.out.println(boardJson);
            System.out.println("=========================");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "Hello World!";
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "hello";
    }

}
