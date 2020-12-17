package com.test.psk.demo.domain;


import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "BOARD")
public class Board extends BaseTimeEntity{//Entity 클래스(DB 테이블과 매칭될 클래스)
    // 언더 스코어 네이밍(_) 으로 이름을 매칭
    // ex) SalesManager.java -> sales_manager table

    @Id//pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙, 기본 값은 auto mysql의 auto_increment로 증가하는 정수값
    private Long no;//MySQL 기준으로 Long 타입은 bigint 타입이 됩니다

//    테이블의 컬럼을 나타내면, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨
//    사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있을경우 사용
//    문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex: length), 타입을 TEXT로 변경하고 싶거나(ex: columnDefinition) 등의 경우에 사용됩니다.


    @Column(nullable = false)
    private String title;
    @Column
    private String contents;
    @Column
    private String writer;


    @Builder // 해당 클래스의 빌더패턴 클래스 생성, 생성자 상단에 선언하면 생성자에 포함된 빌드만 빌더에 포함
    public Board(String title, String contents, String writer) {
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }

    public void update(String title, String contents){
        this.title=title;
        this.contents = contents;
    }

}