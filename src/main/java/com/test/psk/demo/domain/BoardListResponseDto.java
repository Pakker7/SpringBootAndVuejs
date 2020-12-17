package com.test.psk.demo.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardListResponseDto {

    private Long no;
    private String title;
    private String contents;
    private String writer;
    private LocalDateTime createDate;


    public BoardListResponseDto(Board entity) {
        this.no = entity.getNo();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.writer = entity.getWriter();
        this.createDate = entity.getCreateDate();
    }

    @Builder
    public BoardListResponseDto(Long no, String title, String contents, String writer, LocalDateTime createDate) {
        this.no = no;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.createDate = createDate;
    }
}
