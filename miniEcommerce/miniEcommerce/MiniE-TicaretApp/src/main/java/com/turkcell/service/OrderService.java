package com.turkcell.service;

import com.turkcell.entity.Order;
import com.turkcell.entity.OrderItem;
import com.turkcell.entity.Product;
import com.turkcell.repository.IRepository;

import java.util.ArrayList;
import java.util.List;


public class OrderService {

    //Order service 2repository'i de kullanacağı için 2 DI değişkeni oluşturduk.
    IRepository<Order> orderRepository;
    IRepository<Product> productRepository;

    public OrderService(IRepository<Order> orderRepository,
                        IRepository<Product> productRepository)
    {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    // Sipariş oluşturma

    public void createOrder(int orderId, int customerId, List<OrderItem> items) {

        double total = 0;

        List<OrderItem> validItems = new ArrayList<>();

        for (OrderItem item : items) {
            Product product = productRepository.findById(item.getProductId());

            if (product == null) {
                System.out.println("Ürün bulunamadı, id: " + item.getProductId());
                continue;
            }

            if (product.getStock() >= item.getQuantity()) {
                // stoktan düş
                product.setStock(product.getStock() - item.getQuantity());

                // toplam fiyata ekle
                double itemTotal = item.getPrice() * item.getQuantity();
                total += itemTotal;

                validItems.add(item);

                System.out.println(product.getName() + " ürünü sepete eklendi. (" + item.getQuantity() + " adet)");
            } else {
                System.out.println(product.getName() + " ürünü için yeterli stok yok!");
            }
        }

        if (!validItems.isEmpty()) {
            Order order = new Order(orderId, customerId, validItems, total);
            orderRepository.addRegister(order);
            System.out.println("Sipariş oluşturuldu. Toplam: " + total + " TL");
        } else {
            System.out.println("Sipariş oluşturulamadı. Sepet boş.");
        }


    }
}
