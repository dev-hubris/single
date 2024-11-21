package com.example.demo.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/")
    public String home() {
        return "admin_main"; // admin_main.html로 매핑
    }

    @GetMapping("/user_management")
    public String userManagement() {
        return "user_management"; // user_management.html로 매핑
    }

    @GetMapping("/inventory_management")
    public String inventoryManagement() {
        return "inventory_management"; // inventory_management.html로 매핑
    }
}
