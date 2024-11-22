package com.example.demo.admin.service;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Map<String, Object>> getAllProducts();
    Map<String, Object> getProductById(int id);
    void createProduct(Map<String, Object> product);
    void updateProduct(int id, Map<String, Object> productDetails);
    void deleteProduct(int id);
}
