package com.example.demo.admin.controller;

import com.example.demo.admin.controller.MemberController;
import com.example.demo.admin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.admin.service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 회원 관리 페이지
    @GetMapping("/mem_main")
    public String membersPage(Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "MEM"; // templates/MEM.html 파일을 반환
    }

    // 회원 추가
    @PostMapping("/add")
    public String addMember(@RequestParam("name") String name,
                            @RequestParam("email") String email) {
        memberService.addMember(name, email);
        return "redirect:/members/main";
    }

    // 뒤로가기 버튼 처리: 관리자 메인 페이지로 이동
    @GetMapping("/back")
    public String backToAdmin() {
        return "redirect:/admin/main";
    }
}
