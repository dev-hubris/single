package com.example.demo.product.service;



import com.example.demo.product.entity.Category;
import com.example.demo.product.entity.Product;
import com.example.demo.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public List<Product> findAllProducts(){
        return productMapper.findAllProducts();
    }
    public List<Product> findProductsByCategoryId(Long categoryId){
        return productMapper.findProductsByCategoryId(categoryId);
    }
    public List<Category> findCategories() {
        return productMapper.findCategories();
    }

    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
    }


}

