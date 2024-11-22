package com.example.demo.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import com.example.demo.order.dto.OrderDTO;  // OrderDTO를 import


@SpringBootApplication
@Mapper
public interface OrderMapper {
    @Select("select * from new_table")
    List<OrderDTO> findAllProducts();


    // 모든 주문 목록 가져오기
    List<OrderDTO> getAllOrders(); // 반환 타입을 OrderDTO로 수정

    // 특정 주문 가져오기
    OrderDTO getOrderById(@Param("id") int id);  // 반환 타입을 OrderDTO로 수정

    // 주문 생성
    void insertOrder(OrderDTO order);  // Order를 OrderDTO로 수정

    // 주문 수정
    void updateOrder(OrderDTO order);  // Order를 OrderDTO로 수정

    // 주문 삭제
    void deleteOrder(@Param("id") int id);  // 이 부분은 그대로 두어도 됩니다
}

