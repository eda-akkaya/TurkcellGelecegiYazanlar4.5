package com.turkcell.entity;

import java.util.List;

public class Order {
    private int id;
    private int customerId;
    List<OrderItem> orderItems;
    private double totalPrice;

    public Order(){}

    public Order(int id, int customerId, List<OrderItem> orderItems, double totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}


