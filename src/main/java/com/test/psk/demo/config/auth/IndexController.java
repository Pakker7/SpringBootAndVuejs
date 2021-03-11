package com.test.psk.demo.config.auth;

import com.test.psk.demo.config.auth.dto.SessionUser;
import com.test.psk.demo.domain.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final BoardService boardService;
    private final HttpSession httpSession;

    @GetMapping("/login")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", boardService.findAllDesc());

//        // CustomOAuth2UserService 에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구성함
//        // 즉 로그인 성공시 httpSession.getAttribute("user")에서 값을 가져올 수 있다.
//        SessionUser user = (SessionUser)   httpSession.getAttribute("user");
        if(user != null) {
            // 세션에 저장된 값이 있을 때만 model에 userName으로 등록한다.
            // 세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이므로 로그인 버튼이 보이게 됨
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

}
