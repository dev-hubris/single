package com.example.demo.user.controller;

import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    // 회원가입 페이지로 이동
    @GetMapping("/user/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // 빈 객체 전달
        return "/user/register";
    }

    // 회원가입 처리
    @PostMapping("/user/register")
    public String registerUser(User user, Model model) {
        // 비밀번호 암호화 및 데이터베이스 저장
        userService.registerUser(user);

        model.addAttribute("message", "회원가입이 완료되었습니다.");
        return "/user/login"; // 회원가입 완료 후 로그인 페이지로 이동
    }
}
