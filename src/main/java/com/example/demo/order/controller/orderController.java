package com.example.demo.order.controller;

//POJO : Plain Old Java Object

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class orderController {


    @GetMapping("/")  // 확장자 생략
    public String home() {
        return "home"; // view name
        // 경로 : "/WEB-INF/views/home.html"
    }

    @GetMapping("/orderSearch")
    public String orderSearch() {
        return "order/orderSearch"; // view name (ex: "/WEB-INF/views/order.html")
    }
    @GetMapping("/order")
    public String order() {
        return "order"; // view name (ex: "/WEB-INF/views/order.html")
    }
    @GetMapping("/ordercreate")
    public String ordercreate() {
        return "order/ordercreate"; // view name (ex: "/WEB-INF/views/order.html")
    }
    @GetMapping("/orderInfo")
    public String orderInfo() {
        return "order/orderInfo"; // view name (ex: "/WEB-INF/views/order.html")
    }
    }







