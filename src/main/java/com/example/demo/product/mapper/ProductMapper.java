package com.example.demo.product.mapper;

import com.example.demo.product.entity.Category;
import com.example.demo.product.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> findAllProducts();
    List<Product> findProductsByCategoryId(Long categoryId);
    List<Category> findCategories();
    @Insert("INSERT INTO product (name, price) VALUES (#{name}, #{price})")
    void insertProduct(Product product);
    int updateProduct(Product product);
    int deleteProduct(Long id);
    int insertCategory(Category category);
}
