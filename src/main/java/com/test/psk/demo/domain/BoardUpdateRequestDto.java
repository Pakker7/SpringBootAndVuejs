package com.test.psk.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private String title;
    private String contents;

    @Builder
    public BoardUpdateRequestDto(String title, String contents){
        this.title= title;
        this.contents = contents;
    }
}
