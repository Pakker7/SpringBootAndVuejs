package com.test.psk.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private String title;
    private String contents;
    private String writer;
    private LocalDateTime updateDate;

    @Builder
    public BoardUpdateRequestDto(String title, String contents, String writer, LocalDateTime updateDate) {
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.updateDate = updateDate;
    }
}
