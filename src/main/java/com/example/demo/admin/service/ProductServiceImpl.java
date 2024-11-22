package com.example.demo.admin.service;

import com.example.demo.admin.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Map<String, Object>> getAllProducts() {
        return productMapper.getAllProducts();
    }

    @Override
    public Map<String, Object> getProductById(int id) {
        return productMapper.getProductById(id);
    }

    @Override
    public void createProduct(Map<String, Object> product) {
        productMapper.insertProduct(product);
    }

    @Override
    public void updateProduct(int id, Map<String, Object> productDetails) {
        productDetails.put("id", id); // ID 값을 추가
        productMapper.updateProduct(productDetails);
    }

    @Override
    public void deleteProduct(int id) {
        productMapper.deleteProduct(id);
    }
}
