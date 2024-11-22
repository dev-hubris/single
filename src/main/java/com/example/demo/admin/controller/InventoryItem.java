package com.example.demo.admin.controller;

public class InventoryItem {
    private int id;
    private String name;
    private int quantity;
    private int price;

    public InventoryItem(int id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter와 Setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
