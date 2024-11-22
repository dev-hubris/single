package com.example.demo.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    // 대시보드 페이지
    @GetMapping("/main")
    public String dashboardPage(Model model) {
        // 예시 데이터를 모델에 추가하여 다양한 통계를 대시보드에 표시할 수 있도록 설정
        model.addAttribute("totalProducts", 120);
        model.addAttribute("totalOrders", 45);
        model.addAttribute("totalMembers", 200);
        model.addAttribute("totalRevenue", 15000);
        return "DSH"; // templates/DSH.html 파일을 반환
    }

    // 뒤로가기 버튼 처리: 관리자 메인 페이지로 이동
    @GetMapping("/back")
    public String backToAdmin() {
        return "redirect:/admin/main";
    }
}