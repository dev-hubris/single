package com.example.demo.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // 관리자 페이지
    @GetMapping("/main")
    public String adminMainPage() {
        return "ADM"; // templates/ADM.html 파일을 반환
    }

    // 대시보드 페이지
    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "DSH"; // templates/DSH.html 파일을 반환
    }

    // 재고 관리 페이지
    @GetMapping("/inventory")
    public String inventoryPage() {
        return "INV"; // templates/INV.html 파일을 반환
    }

    // 회원 관리 페이지
    @GetMapping("/members")
    public String membersPage() {
        return "MEM"; // templates/MEM.html 파일을 반환
    }

    // 주문 관리 페이지
    @GetMapping("/orders")
    public String ordersPage() {
        return "ORD"; // templates/ORD.html 파일을 반환
    }

    // 제품 관리 페이지
    @GetMapping("/products")
    public String productsPage() {
        return "PRO"; // templates/PRO.html 파일을 반환
    }
}
