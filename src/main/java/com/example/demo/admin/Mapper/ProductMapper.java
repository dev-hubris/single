package com.example.demo.admin.Mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM product")
    List<Map<String, Object>> getAllProducts();

    @Select("SELECT * FROM product WHERE id = #{id}")
    Map<String, Object> getProductById(@Param("id") int id);

    @Insert("INSERT INTO product (name, description, price, category_id) VALUES (#{name}, #{description}, #{price}, #{categoryId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertProduct(Map<String, Object> product);

    @Update("UPDATE product SET name = #{name}, description = #{description}, price = #{price}, category_id = #{categoryId} WHERE id = #{id}")
    void updateProduct(Map<String, Object> product);

    @Delete("DELETE FROM product WHERE id = #{id}")
    void deleteProduct(@Param("id") int id);
}
