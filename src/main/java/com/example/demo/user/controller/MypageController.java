package com.example.demo.user.controller;

import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MypageController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/mypage")
    public String myPage(Model model, Principal principal) {
        String userId = principal.getName(); // 현재 로그인된 사용자 아이디 가져오기
        User user = userService.getUserByUserId(userId); // 사용자 정보 조회
        model.addAttribute("user", user);
        return "/user/mypage"; // mypage.html 반환
    }
}