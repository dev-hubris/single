package com.example.demo.order.controller;

//POJO : Plain Old Java Object

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class orderController {


//    @GetMapping("/")  // 확장자 생략
//    public String home() {
//        return "home"; // view name
//        // 경로 : "/WEB-INF/views/home.html"
////    }

    @GetMapping("/order/orderSearch")
    public String orderSearch() {
        return "order/orderSearch"; // view name (ex: "/WEB-INF/views/order.html")
    }
    @GetMapping("/order/orderInfo1")
    public String order() {
        return "/order/orderInfo1"; // view name (ex: "/WEB-INF/views/order.html")
    }
    @GetMapping("/order/ordercreate")
    public String ordercreate() {
        return "order/ordercreate"; // view name (ex: "/WEB-INF/views/order.html")
    }
    @GetMapping("/order/orderInfo2")
    public String orderInfo() {
        return "order/orderInfo2"; // view name (ex: "/WEB-INF/views/order.html")
    }
}






    