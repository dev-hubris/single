package com.example.demo.product.controller;



//POJO : Plain Old Java Object

import com.example.demo.product.entity.Product;
import com.example.demo.product.mapper.ProductMapper;
import com.example.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;


    @GetMapping("/")  // 확장자 생략
    public String home() {
        return "product/home"; // view name
        // 경로 : "/WEB-INF/views/home.html"
    }

    @GetMapping("/product/productDetails")
    public String detail() {
        return "product/product_detail";
    }

    @GetMapping("/product/productSearch")
    public String search() {
        return "product/product_search";
    }

    @GetMapping("/product/productLists")
    public String view() {
        return "product/product_view";
    }



    @GetMapping("/product")
    public String showProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "product/productForm";

    }


    @GetMapping("/productForm")
    public String productForm(Model model) {
        model.addAttribute("product", new Product());  // Create a new product object to bind the form
        return "product/productForm";  // Return the Thymeleaf template
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute Product product, Model model) {
        // Save the product
        if (product.getName() == null || product.getName().isEmpty()) {
            model.addAttribute("error", "Product name is required.");
            return "product/productForm";
        }
        productMapper.insertProduct(product);
        return "redirect:/product/productLists";  // Redirect to a success page or product list page
    }

}






