package com.test.psk.demo.web.board.old;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HelloResponseDto {

    private String name;
    private int amount;

    @Builder
    public HelloResponseDto(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}
