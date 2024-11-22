//package com.example.demo.admin.controller;
//
//import com.example.demo.admin.controller.InventoryItem;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class InventoryController {
//
//    private List<InventoryItem> inventoryList = new ArrayList<>();
//
//    public InventoryController() {
//        // 초기 데이터 추가
//        inventoryList.add(new InventoryItem(1, "샘플 상품 1", 100, 10000));
//        inventoryList.add(new InventoryItem(2, "샘플 상품 2", 50, 20000));
//    }
//
//    // 재고 페이지
//    @GetMapping("/admin/inventory")
//    public String inventoryPage(Model model) {
//        model.addAttribute("inventoryList", inventoryList);
//        return "inventory"; // templates/inventory.html
//    }
//
//    // 재고 추가
//    @PostMapping("/admin/inventory/add")
//    public String addInventoryItem(String productName, int quantity, int price) {
//        int nextId = inventoryList.size() + 1; // 새로운 ID 생성
//        inventoryList.add(new InventoryItem(nextId, productName, quantity, price));
//        return "redirect:/admin/inventory"; // 재고 페이지로 리다이렉트
//    }
//}
