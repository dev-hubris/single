package com.example.demo.product.mapper;

import com.example.demo.product.entity.Category;
import com.example.demo.product.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("select * from tbl_product")
    List<Product> findAllProducts();
    List<Product> findProductsByCategoryId(Long categoryId);
    List<Category> findCategories();
    @Insert(" INSERT INTO tbl_product (prod_code, prod_name, prod_origin_price, prod_saleprice, prod_category, prod_category_detail, prod_desc, prod_main_img_path, prod_date, prod_edit_date, prod_quantity, prod_sales_dist)\n" +
            "        VALUES (#{prod_code}, #{prod_name}, #{prod_origin_price}, #{prod_saleprice}, #{prod_category}, #{prod_category_detail}, #{prod_desc}, #{prod_main_img_path}, #{prod_date}, #{prod_edit_date}, #{prod_quantity}, #{prod_sales_dist})")
    void insertProduct(Product product);
    int updateProduct(Product product);
    int deleteProduct(Long id);
    int insertCategory(Category category);
}
