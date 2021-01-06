package com.test.psk.demo.config.auth.dto;


import com.test.psk.demo.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    // SessionUser에는 인증된 사용자 정보만 필요합니다. 그외에 필요한 정보들은 없으니
    // name, email, picture만 필드로 선언합니다.

    // Q. User 엔티티랑 똑같아서 그거 사용해도 되는데 굳이 SessionUser를 만든이유?
    // A. User 클래스를 그대로 세션에 저장하려고 하면, 직렬화를 구현하지 않아서 에러가 난다
    // 직렬화 구현은 쉽게 결정할수 없는 문젠데 이유는 User가 엔티티라서 여기저기 엔티티들이랑 엮일 수 있는데
    // 자식이 많아진다거나 다대다로 얽혔을 때 직렬화하면 에러날때 여기저기 난리가 날테니
    // 그냥 따로 구현하는게 낫다.
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
