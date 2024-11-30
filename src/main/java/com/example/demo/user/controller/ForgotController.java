package com.example.demo.user.controller;

import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ForgotController {

    @Autowired
    private UserService userService; // 사용자 정보 확인

    @Autowired
    private JavaMailSender mailSender; // 이메일 전송

    // 비밀번호 찾기 페이지
    @GetMapping("/user/forgot")
    public String showForgotPasswordForm() {
        return "/user/forgot"; // forgot.html로 이동
    }

    // 비밀번호 찾기 요청 처리
    @PostMapping("/user/forgot")
    public String handleForgotPassword(@RequestParam String userId, @RequestParam String email, Model model) {
        boolean userExists = userService.validateUserByIdAndEmail(userId, email);
        if (userExists) {
            String tempPassword = userService.generateTemporaryPassword(); // 임시 비밀번호 생성
            userService.updateUserPassword(userId, tempPassword); // 비밀번호 업데이트
            userService.sendTemporaryPassword(email, tempPassword); // 이메일 전송

            model.addAttribute("alertMessage", "임시 비밀번호가 이메일로 전송되었습니다.");
            model.addAttribute("redirectUrl", "/home"); // 성공 시 이동할 URL 설정
        } else {
            model.addAttribute("error", "아이디와 이메일이 일치하지 않습니다.");

        }
        return "/user/forgot"; // 비밀번호 찾기 페이지 반환
    }
}
