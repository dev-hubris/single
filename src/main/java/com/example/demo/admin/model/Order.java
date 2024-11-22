package com.example.demo.admin.model;

public class Order {

    private String productId;
    private int quantity;

    // 생성자
    public Order(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getter 및 Setter
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
