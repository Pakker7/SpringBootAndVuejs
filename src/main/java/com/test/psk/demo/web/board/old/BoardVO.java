package com.test.psk.demo.web.board.old;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardVO {
    private int no;
    private String title;
    private String contents;
    private String writer;
    private Date createDate;
    private Date updateDate;
}
