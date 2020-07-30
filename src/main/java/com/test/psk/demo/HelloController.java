package com.test.psk.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String test() {
        return "Hello World!";
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "hello";
    }

}
