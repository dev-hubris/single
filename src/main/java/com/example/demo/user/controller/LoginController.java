package com.example.demo.user.controller;

import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 로그인 페이지 표시
     */
    @GetMapping("/user/login")
    public String showLoginForm(
            @RequestParam(value = "error", required = false) String error,
            Model model) {
        // Spring Security에서 인증 실패 시 'error=true' 파라미터가 추가됨
        if (error != null) {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
        }
        return "/user/login"; // login.html 반환
    }

    /**
     * 로그인 처리
     */
    @PostMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {
        User user = userService.authenticateUser(username, password);

        if (user != null) {
            // 로그인 성공 시 사용자 정보를 세션에 저장
            session.setAttribute("loggedInUser", user);
            return "redirect:/user/profile"; // 프로필 페이지로 이동
        } else {
            // 로그인 실패 시 에러 메시지와 함께 다시 로그인 페이지로 이동
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "/user/login";
        }
    }
}