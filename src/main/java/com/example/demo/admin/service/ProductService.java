package com.example.demo.admin.service;

import com.example.demo.admin.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList = new ArrayList<>();

    public List<Product> getAllProducts() {
        return productList;
    }

    public void addProduct(String name, double price) {
        productList.add(new Product(name, price));
    }
}
