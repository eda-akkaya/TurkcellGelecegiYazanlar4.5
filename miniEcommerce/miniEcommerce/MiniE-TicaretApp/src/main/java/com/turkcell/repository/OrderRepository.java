package com.turkcell.repository;

import com.turkcell.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IRepository<Order>{

    List<Order> orders = new ArrayList<>();

    @Override
    public void addRegister(Order order) {
        orders.add(order);
        System.out.println("Sipariş başarıyla kaydedildi. Sipariş No: " + order.getId());

    }

    public Order findById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }
}
