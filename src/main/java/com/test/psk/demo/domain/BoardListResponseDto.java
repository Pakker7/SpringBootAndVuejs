package com.test.psk.demo.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardListResponseDto {

    private Long no;
    private String title;
    private String contents;
    private String writer;


    public BoardListResponseDto(Board entity){
        this.no = entity.getNo();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.writer = entity.getWriter();
    }

    @Builder
    public BoardListResponseDto(Long no, String title, String contents, String writer) {
        this.no = no;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }
}
