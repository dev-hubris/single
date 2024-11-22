package com.example.demo.order.controller;

import com.example.demo.order.dto.OrderDTO;
import com.example.demo.order.mapper.OrderMapper;
import com.example.demo.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;




    @GetMapping("/order/orderSearch")
    public String orderSearch(Model model) {
        model.addAttribute("new_table", "");
        return "order/orderSearch"; // view name (ex: "/WEB-INF/views/order.html")
    }
    @GetMapping("/order/orderInfo1")
    public String order() {
        return "order/orderInfo1"; // view name (ex: "/WEB-INF/views/order.html")
    }

    @GetMapping("/order/ordercreate")
    public String ordercreate() {
        return "order/ordercreate"; // view name (ex: "/WEB-INF/views/order.html")
    }

    @GetMapping("/order/orderInfo2")
    public String orderInfo() {
        return "order/orderInfo2"; // view name (ex: "/WEB-INF/views/order.html")
    }



    @GetMapping("/order/orders")
    public String orderList(Model model) {
        List<OrderDTO> orders = orderService.findAllProducts();
        model.addAttribute("orders", orders);
        return "order/orderSearch"; // View for listing all products
    }
}

