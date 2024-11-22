package com.example.demo.admin.service;

import com.example.demo.admin.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    private List<Product> productList = new ArrayList<>();

    public InventoryService() {
        // 임시로 제품 데이터를 추가
        productList.add(new Product("1", "Product A", 100.0, 50));
        productList.add(new Product("2", "Product B", 50.0, 20));
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public void updateProductQuantity(String productId, int quantity) {
        for (Product product : productList) {
            if (product.getId().equals(productId)) {
                product.setQuantity(quantity);
                break;
            }
        }
    }
}
