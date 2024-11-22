package com.example.demo.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/")
    public String redirectToAdminMain() {
        return "redirect:/admin/main";
    }

    @GetMapping("/admin/main")
    public String admPage() {
        return "admin/ADM";
    }

    @GetMapping("/admin/dashboard")
    public String dshPage() {
        return "admin/DSH";
    }

    @GetMapping("/admin/inventory")
    public String invPage() {
        return "admin/INV";
    }

    @GetMapping("/admin/users")
    public String memPage() {
        return "admin/USR";
    }

    @GetMapping("/admin/orders")
    public String ordPage() {
        return "admin/ORD";
    }

    @GetMapping("/admin/products")
    public String proPage() {
        return "admin/PRO";
    }
}
