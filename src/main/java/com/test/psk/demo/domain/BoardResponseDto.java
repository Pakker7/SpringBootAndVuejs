package com.test.psk.demo.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {

    private Long no;
    private String title;
    private String contents;
    private String writer;
    private LocalDateTime createDate;

    public BoardResponseDto (Board entity){ // entity의 필드 중 일부만 사용, 생성자로 entity를 받아 필드에 값을 넣음
                                            // 모든 필드가진 생성자는 필요하진 않아서 Dto는 entity를 받아서처리
        this.no = entity.getNo();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.writer = entity.getWriter();
        this.createDate = entity.getCreateDate();
    }
}
