package com.web.cart_service.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {

    private String orderId;

    private String userId;

    private List<CartItem> items;

    private Double total;

    private String status;

    private LocalDateTime createdAt;

    public Order() {
    }

    public Order(String userId,
                 List<CartItem> items,
                 Double total) {

        this.orderId = UUID.randomUUID().toString();
        this.userId = userId;
        this.items = items;
        this.total = total;
        this.status = "CREATED";
        this.createdAt = LocalDateTime.now();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}