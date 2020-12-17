package com.test.psk.demo.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //이건왜..?
public enum Role {

    GUEST("ROLE_GUEST", "손님"), //spring security에는 권한 코드에 항상 ROLE_이 앞에 있어야 함...!!!!!!!!!!
    USER("ROLE_USER", "일반 사용자"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;

}
