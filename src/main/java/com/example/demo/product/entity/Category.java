package com.example.demo.product.entity;

public class Category {
    private Long prod_id;
    private String name;

    // Getters and Setters
    public Long getId() {
        return prod_id;
    }

    public void setId(Long id) {
        this.prod_id = prod_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

