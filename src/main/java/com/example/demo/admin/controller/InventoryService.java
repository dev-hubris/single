package com.example.demo.admin.controller;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class InventoryService {

    // 임시 데이터베이스 역할을 하는 리스트
    private List<Product> productList = new ArrayList<>();

    // 모든 제품을 반환하는 메서드
    public List<Product> getAllProducts() {
        return productList;
    }

    // 제품 수량을 업데이트하는 메서드
    public void updateProductQuantity(String productId, int quantity) {
        for (Product product : productList) {
            if (product.getId().equals(productId)) {
                product.setQuantity(quantity);
                return;
            }
        }
    }

    // 새로운 제품을 추가하는 메서드 (추가 기능을 원한다면)
    public void addProduct(Product product) {
        productList.add(product);
    }
}
