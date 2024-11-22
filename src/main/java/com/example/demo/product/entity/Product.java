package com.example.demo.product.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product {

    private Long prod_id;
    private Long prod_code;
    private String prod_name;
    private Long prod_origin_price;
    private Long prod_saleprice;
    private String prod_category;
    private String prod_category_detail;
    private String prod_desc;
    private String prod_main_img_path;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prod_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prod_edit_date;

    private Long prod_quantity;
    private String prod_sales_dist;

    public Long getId() {
        return prod_id;
    }

    public void setId(Long id) {
        this.prod_id = prod_id;
    }

    public Long getProd_code() {
        return prod_code;
    }

    public void setProd_code(Long prod_code) {
        this.prod_code = prod_code;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public Long getProd_origin_price() {
        return prod_origin_price;
    }

    public void setProd_origin_price(Long prod_origin_price) {
        this.prod_origin_price = prod_origin_price;
    }

    public Long getProd_saleprice() {
        return prod_saleprice;
    }

    public void setProd_saleprice(Long prod_saleprice) {
        this.prod_saleprice = prod_saleprice;
    }

    public String getProd_category() {
        return prod_category;
    }

    public void setProd_category(String prod_category) {
        this.prod_category = prod_category;
    }

    public String getProd_category_detail() {
        return prod_category_detail;
    }

    public void setProd_category_detail(String prod_category_detail) {
        this.prod_category_detail = prod_category_detail;
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }

    public String getProd_main_img_path() {
        return prod_main_img_path;
    }

    public void setProd_main_img_path(String prod_main_img_path) {
        this.prod_main_img_path = prod_main_img_path;
    }

    public Date getProd_date() {
        return prod_date;
    }

    public void setProd_date(Date prod_date) {
        this.prod_date = prod_date;
    }

    public Date getProd_edit_date() {
        return prod_edit_date;
    }

    public void setProd_edit_date(Date prod_edit_date) {
        this.prod_edit_date = prod_edit_date;
    }

    public Long getProd_quantity() {
        return prod_quantity;
    }

    public void setProd_quantity(Long prod_quantity) {
        this.prod_quantity = prod_quantity;
    }

    public String getProd_sales_dist() {
        return prod_sales_dist;
    }

    public void setProd_sales_dist(String prod_sales_dist) {
        this.prod_sales_dist = prod_sales_dist;
    }



}
