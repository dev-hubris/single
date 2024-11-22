//package com.example.demo.admin.controller;
//
//import com.example.demo.admin.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/admin/products")
//public class OrdersController {
//
//    @Autowired
//    private ProductService productService;
//
//    // 제품 관리 페이지
//    @GetMapping("/main")
//    public String productsPage(Model model) {
//        model.addAttribute("products", productService.getAllProducts());
//        return "PRO"; // templates/PRO.html 파일을 반환
//    }
//
//    // 제품 추가
//    @PostMapping("/add")
//    public String addProduct(@RequestParam("name") String name,
//                             @RequestParam("price") double price) {
//        productService.addProduct(name, price);
//        return "redirect:/admin/products/main";
//    }
//
//    // 뒤로가기 버튼 처리: 관리자 메인 페이지로 이동
//    @GetMapping("/back")
//    public String backToAdmin() {
//        return "redirect:/admin/main";
//    }
//}