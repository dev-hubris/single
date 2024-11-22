package com.example.demo.order.service;

import com.example.demo.order.mapper.OrderMapper;
import com.example.demo.order.dto.OrderDTO;  // OrderDTO를 import
import lombok.RequiredArgsConstructor;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDTO> findAllProducts(){
        return orderMapper.findAllProducts();
    }


    // 모든 주문 가져오기
    public List<OrderDTO> getAllOrders() {
        return orderMapper.getAllOrders();  // 반환 타입을 OrderDTO로 수정
    }

    // 특정 주문 가져오기
    public OrderDTO getOrderById(int id) {
        return orderMapper.getOrderById(id);  // 반환 타입을 OrderDTO로 수정
    }

    // 주문 생성
    public void createOrder(OrderDTO order) {
        orderMapper.insertOrder(order);  // 매개변수를 OrderDTO로 수정
    }

    // 주문 수정
    public void updateOrder(OrderDTO order) {
        orderMapper.updateOrder(order);  // 매개변수를 OrderDTO로 수정
    }

    // 주문 삭제
    public void deleteOrder(int id) {
        orderMapper.deleteOrder(id);  // 매개변수는 그대로
    }

}
