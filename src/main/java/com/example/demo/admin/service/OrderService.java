package com.example.demo.admin.service;

import com.example.demo.admin.model.Order; // Order 클래스 임포트
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private List<Order> orderList = new ArrayList<>();

    public List<Order> getAllOrders() {
        return orderList;
    }

    public void addOrder(String productId, int quantity) {
        orderList.add(new Order(productId, quantity));
    }
}
