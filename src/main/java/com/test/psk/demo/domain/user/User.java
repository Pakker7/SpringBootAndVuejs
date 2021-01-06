package com.test.psk.demo.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)// PK 생성 규칙, 기본 값은 auto mysql의 auto_increment로 증가하는 정수값
    private String id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING) //jpa로 데이터 베이스를 저장 할 떄 Enum 값을 어떤 형태로 저장할지 결정
                                    // 기본적으로는 int 로 된 숫자가 저장-->? 순서대로 int를 부여한다는 건지...?
                                    // 숫자로 젖아되면 데이터 베이스로 확인 할 때 그 값이 무슨 코드를 의미하는지 알기 어려움
                                    // 따라서 지금은 문자열로 저장될 수 있또록 선언
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
