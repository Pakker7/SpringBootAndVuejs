package com.test.psk.demo.config.auth;

import com.test.psk.demo.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // spring security 설정들을 활성화 시켜 줍니다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable()
                .and()
                    .authorizeRequests() // url 별 권한 관리를 설정하는 옵션의 시작 이거를 무조건 써야 antMachers를 쓸수있음
                    .antMatchers("/","css/**","/images/**","/js/**","h2-console/**").permitAll() //전체 접근 허용
                    .antMatchers("/api/**").hasRole(Role.USER.name()) //여기는 Role User만 접근 허용
                    .anyRequest() // 설정 외의 나머지 url은
                        .authenticated() //인증된 사용자(로그인사용자)만 허용하도록 함
                .and()
                    .logout()
                        .logoutSuccessUrl("/") // 로그아웃 성공시 /로 이동
                .and()
                    .oauth2Login()// Oauth2 로그인 기능을 설정하는 옵션의 시작 이거를 무조건 써야 나머지 설정이 가능
                        .userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 떄의 설정들을 담당함-->?
                            .userService(customOAuth2UserService);
                                    //소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 여기에 등록함
                                    // 리소스 서버(즉, 소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있음
    }
}
