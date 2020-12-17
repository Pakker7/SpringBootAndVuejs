package com.test.psk.demo.web.board.old;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @PostMapping("/hello/dto")
    public HelloResponseDto hellodto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return HelloResponseDto.builder()
                .amount(amount)
                .name(name)
                .build();
    }
}
