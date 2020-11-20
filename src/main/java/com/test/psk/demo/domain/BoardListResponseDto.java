package com.test.psk.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BoardListResponseDto {

    private Long no;
    private String title;
    private String contents;
    private String writer;

    @Builder
    public BoardListResponseDto(Long no, String title, String contents, String writer) {
        this.no = no;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }
}
