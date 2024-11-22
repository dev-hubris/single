package com.example.demo.admin.controller;

import com.example.demo.admin.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // 재고 관리 페이지
    @GetMapping("/inv_main")
    public String inventoryPage(Model model) {
        model.addAttribute("products", inventoryService.getAllProducts());
        return "INV"; // templates/INV.html 파일을 반환
    }

    // 재고 업데이트
    @PostMapping("/update")
    public String updateInventory(@RequestParam("productId") String productId,
                                  @RequestParam("quantity") int quantity) {
        inventoryService.updateProductQuantity(productId, quantity);
        return "redirect:/inventory/main";
    }

    // 뒤로가기 버튼 처리: 관리자 메인 페이지로 이동
    @GetMapping("/back")
    public String backToAdmin() {
        return "redirect:/admin/main";
    }
}
