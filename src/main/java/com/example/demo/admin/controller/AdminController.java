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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private InventoryService inventoryService;

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
    public String inventoryPage(Model model) {
        model.addAttribute("products", inventoryService.getAllProducts());
        return "INV"; // templates/INV.html 파일을 반환
    }

    // 재고 업데이트
    @PostMapping("/inventory/update")
    public String updateInventory(@RequestParam("productId") String productId,
                                  @RequestParam("quantity") int quantity) {
        inventoryService.updateProductQuantity(productId, quantity);
        return "redirect:/admin/inventory";
    }

    // 회원 관리 페이지
    @GetMapping("/members")
    public String membersPage() {
        return "MEM"; // templates/MEM.html 파일을 반환
    }

    // 회원 추가 페이지
    @PostMapping("/members/add")
    public String addMember(@RequestParam("name") String name,
                            @RequestParam("email") String email) {
        // 회원 추가 로직 처리
        // memberService.addMember(new Member(name, email));
        return "redirect:/admin/members";
    }

    // 주문 관리 페이지
    @GetMapping("/orders")
    public String ordersPage(Model model) {
        // 주문 내역 리스트를 가져와 모델에 추가
        // List<Order> orders = orderService.getAllOrders();
        // model.addAttribute("orders", orders);
        return "ORD"; // templates/ORD.html 파일을 반환
    }

    // 주문 추가 페이지
    @PostMapping("/orders/add")
    public String addOrder(@RequestParam("productId") String productId,
                           @RequestParam("quantity") int quantity) {
        // 주문 추가 로직 처리
        // orderService.addOrder(new Order(productId, quantity));
        return "redirect:/admin/orders";
    }

    // 제품 관리 페이지
    @GetMapping("/products")
    public String productsPage(Model model) {
        // 제품 리스트를 가져와 모델에 추가
        // List<Product> products = productService.getAllProducts();
        // model.addAttribute("products", products);
        return "PRO"; // templates/PRO.html 파일을 반환
    }

    // 제품 추가 페이지
    @PostMapping("/products/add")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("price") double price) {
        // 제품 추가 로직 처리
        // productService.addProduct(new Product(name, price));
        return "redirect:/admin/products";
    }
}
