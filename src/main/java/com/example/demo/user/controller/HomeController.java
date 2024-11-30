package com.example.demo.user.controller;

import com.example.demo.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/home")
    public String homePage(Model model, Principal principal) {
        // 1. Principal로 사용자 ID 가져오기
        if (principal != null) {
            String username = principal.getName(); // Spring Security에서 로그인된 사용자 이름
            String name = userMapper.findNameByUserId(username);
            model.addAttribute("username", name);
            System.out.println("로그인한 사용자 ID: " + username); // 로그로 확인
        } else {
            System.out.println("Principal 객체가 null입니다. 사용자 정보 없음.");
            model.addAttribute("username", "Guest"); // 로그인되지 않은 사용자 처리
        }

        return "home"; //// home.html 반환
    }
}
