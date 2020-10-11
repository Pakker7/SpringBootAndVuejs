package com.test.psk.demo.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
    jpa 공부를 위한 class
*/


@NoArgsConstructor(access = AccessLevel.PROTECTED)
// access = AccessLevel.PROTECTED  기본 생성자의 접근 제어를 PROTECTED로 설정해놓는 것임
// 무분별한 객체 생성에 대해 한번 더 체크할 수 있는 수단
// 추가로 모든 정보를 가지고 있어야지 생성자를 만들 수 있게 함으로써 불완전한 객체 생성을 막음
@Entity
@Getter
public class Posts { //Entity 클래스(DB 테이블과 매칭될 클래스)
                    // 언더 스코어 네이밍(_) 으로 이름을 매칭
                    // ex) SalesManager.java -> sales_manager table

    @Id //pk
    @GeneratedValue // PK 생성 규칙, 기본 값은 auto mysql의 auto_increment로 증가하는 정수값
    private Long id; //MySQL 기준으로 Long 타입은 bigint 타입이 됩니다


//    테이블의 컬럼을 나타내면, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨
//    사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있을경우 사용
//    문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex: length), 타입을 TEXT로 변경하고 싶거나(ex: columnDefinition) 등의 경우에 사용됩니다.

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private  String content;

    private String author;

    @Builder // 해당 클래스의 빌더패턴 클래스 생성, 생성자 상단에 선언하면 생성자에 포함된 빌드만 빌더에 포함 --> 무슨말?
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }



}
