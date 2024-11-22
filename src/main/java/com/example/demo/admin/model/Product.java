package com.example.demo.admin.model;

public class Product {

    private String id;
    private String name;
    private double price;
    private int quantity;

    // 기본 생성자
    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // 오버로딩된 생성자 (id를 자동 생성하지 않을 경우)
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0; // 초기 재고 수량을 기본적으로 0으로 설정
    }

    // Getter 및 Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
