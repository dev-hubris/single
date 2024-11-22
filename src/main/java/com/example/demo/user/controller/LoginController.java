package com.example.demo.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

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
}