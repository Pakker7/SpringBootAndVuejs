package com.test.psk.demo.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ParamBoardVO {
    private int NO;
    private String TITLE;
    private String CONTENTS;
    private String WRITER;
    private Date DATE;
}
