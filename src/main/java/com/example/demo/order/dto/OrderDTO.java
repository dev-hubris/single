package com.example.demo.order.dto;



public class OrderDTO {
    private int orderId;
    private String orderStatus;
    private String orderAttnEmail;
    private String orderAttnPhone;
    private String orderAttnPostcode;
    private String orderAttnAddr1;
    private String orderAttnAddr2;
    private String orderAttnAddrDetail;
    private String orderAttnRequest;
    private String orderDate;
    private String orderPayStatus;
    private String orderTotalPrice;
    private String orderName;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderAttnEmail() {
        return orderAttnEmail;
    }

    public void setOrderAttnEmail(String orderAttnEmail) {
        this.orderAttnEmail = orderAttnEmail;
    }

    public String getOrderAttnPhone() {
        return orderAttnPhone;
    }

    public void setOrderAttnPhone(String orderAttnPhone) {
        this.orderAttnPhone = orderAttnPhone;
    }

    public String getOrderAttnPostcode() {
        return orderAttnPostcode;
    }

    public void setOrderAttnPostcode(String orderAttnPostcode) {
        this.orderAttnPostcode = orderAttnPostcode;
    }

    public String getOrderAttnAddr1() {
        return orderAttnAddr1;
    }

    public void setOrderAttnAddr1(String orderAttnAddr1) {
        this.orderAttnAddr1 = orderAttnAddr1;
    }

    public String getOrderAttnAddr2() {
        return orderAttnAddr2;
    }

    public void setOrderAttnAddr2(String orderAttnAddr2) {
        this.orderAttnAddr2 = orderAttnAddr2;
    }

    public String getOrderAttnAddrDetail() {
        return orderAttnAddrDetail;
    }

    public void setOrderAttnAddrDetail(String orderAttnAddrDetail) {
        this.orderAttnAddrDetail = orderAttnAddrDetail;
    }

    public String getOrderAttnRequest() {
        return orderAttnRequest;
    }

    public void setOrderAttnRequest(String orderAttnRequest) {
        this.orderAttnRequest = orderAttnRequest;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderPayStatus() {
        return orderPayStatus;
    }

    public void setOrderPayStatus(String orderPayStatus) {
        this.orderPayStatus = orderPayStatus;
    }

    public String getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(String orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;
}
