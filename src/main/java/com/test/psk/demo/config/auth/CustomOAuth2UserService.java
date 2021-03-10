package com.test.psk.demo.config.auth;


import com.test.psk.demo.config.auth.dto.OAuthAttributes;
import com.test.psk.demo.config.auth.dto.SessionUser;
import com.test.psk.demo.domain.user.User;
import com.test.psk.demo.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService {

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // registration -> 현재 로그인 진행중인 서비스를 구분하는 코드, 지금은 google만이지만 추후 naver,kakao추가할 때 사용
        String registrationId = userRequest.getClientRegistration()
                .getRegistrationId();
        // userNameAttributeName -> OAuth2 로그인 진행 시 키가 되는 필드 값을 이야기함. Primary Key와 같은 의미
        // 구글은 기본코드("sub")를 지원하지만 네이버 카카오는 기본 코드를 지원하지 않음
        // 이후 네이버 로그인과 구글 로그인을 동시 지원할 떄 사용됨.
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
        // OAuth2UserService를 통해 가져온 OAuth2User 의 attribute를 담을 클래스
        // 이후 네이버 등 다른 소셜 로그인도 이 클래스를 사용할 것임

        User user = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionUser(user));  // 세션에 사용자 정보를 저장하기 위한 Dto클래스

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())), // ????
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }


    private User saveOrUpdate(OAuthAttributes attributes) {
        User user = userRepository.findByEmail(attributes.getEmail())
                .map(entity->entity.update(attributes.getName(), attributes.getPicture())) // ???? entity.update? 조건이뭐지...
                .orElse(attributes.toEntity()); // orElse -> 객체가 null일 경우에 실행(Optional)

        return userRepository.save(user);
    }
}