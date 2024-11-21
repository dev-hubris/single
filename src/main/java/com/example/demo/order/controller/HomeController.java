package com.example.demo.order.controller;

//POJO : Plain Old Java Object

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")  // 확장자 생략
    public String home() {
        return "home"; // view name
        // 경로 : "/WEB-INF/views/home.html"
    }
     @GetMapping("/product/productDetails")
    public String detail() {
        return "product_detail";
    }

    @GetMapping("/product/productSearch")
    public String search() {
        return "product_search";
    }

    @GetMapping("/product/productLists")
    public String view() {
        return "product_view";
    }


    @GetMapping("/orderSearch")
    public String orderSearch() {
        return "orderSearch"; // view name (ex: "/WEB-INF/views/order.html")
    }
    @GetMapping("/order")
    public String order() {
        return "order"; // view name (ex: "/WEB-INF/views/order.html")
    }
    @GetMapping("/ordercreate")
    public String ordercreate() {
        return "ordercreate"; // view name (ex: "/WEB-INF/views/order.html")
    }

    @GetMapping("/orderInfo")
    public String orderInfo() {
        return "orderInfo"; // view name (ex: "/WEB-INF/views/order.html")
    }
    }






