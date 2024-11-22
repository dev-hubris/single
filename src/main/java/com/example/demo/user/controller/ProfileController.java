package com.example.demo.user.controller;

import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    // 회원 정보 수정 폼 보여주기
    @GetMapping("/user/profile")
    public String showProfileForm(Model model, Principal principal) {
        String userId = principal.getName(); // 현재 로그인된 사용자 아이디 가져오기
        User user = userService.getUserByUserId(userId); // 사용자 정보 조회
        model.addAttribute("username", user.getName());
        model.addAttribute("userId", userId);
        model.addAttribute("userbirth", user.getBirthdate());
        return "user/profile"; // profile.html 반환
    }

    // 회원 정보 수정 처리
    @PostMapping("/user/updateProfile")
    public String updateProfile(User user, Principal principal) {
        String userId = principal.getName(); // 현재 로그인된 사용자 아이디 가져오기
        user.setUserId(userId); // 해당 사용자의 정보만 수정하도록 설정
        userService.updateUserProfile(user); // DB에서 사용자 정보 업데이트
        return "redirect:/user/mypage"; // 수정 완료 후 마이페이지로 리다이렉트
    }
}