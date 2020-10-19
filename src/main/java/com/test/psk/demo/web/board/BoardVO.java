package com.test.psk.demo.web.board;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "BOARD") //얘는 왜 빨간줄인지..?
public class BoardVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false)
    private String title;
    @Column
    private String contents;
    @Column
    private String writer;

    @Builder
    public BoardVO(String title, String contents, String writer) {
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }
//    private int no;
//    private String title;
//    private String contents;
//    private String writer;
//    private Date createDate;
//    private Date updateDate;

}
