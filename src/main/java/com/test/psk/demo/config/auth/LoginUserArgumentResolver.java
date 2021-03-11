package com.test.psk.demo.config.auth;

import com.test.psk.demo.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // supportsParameter() 컨트롤러 메서드의 특정 파라미터를 지원하는지 판단합니다.
        // 여기서는 파라미터에 @Loginuser어노테이션이 붙어 있고, 파라미터 클래스 타입이 Sessionuser.class인 경우 true를 반환합니다.

        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
        System.out.println(SessionUser.class); //이거 프린트 하면 어떻게 되지..?
        System.out.println(parameter.getParameterType()); //이거 프린트 하면 어떻게 되지..?
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());

        return isLoginUserAnnotation && isUserClass;
    }

    @Override // resolveArgument 파라미터에 전달할 객체를 생성함, 여기서는 세션에서 객체를 가져오는 역할
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return httpSession.getAttribute("user");
    }
}
