package com.turkcell;

import com.turkcell.entity.Customer;
import com.turkcell.entity.OrderItem;
import com.turkcell.entity.Product;
import com.turkcell.repository.CustomerRepository;
import com.turkcell.repository.OrderRepository;
import com.turkcell.repository.ProductRepository;
import com.turkcell.service.CustomerService;
import com.turkcell.service.OrderService;
import com.turkcell.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Müşteri işlemleri
        CustomerService customerService = new CustomerService(new CustomerRepository());

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Utku");
        customerService.customerRegistration(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Özgür");
        customerService.customerRegistration(customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setName("Eda");
        customerService.customerRegistration(customer3);

        customerService.findCustomer(4);


        // Ürün İşlemleri
        ProductRepository productRepository = new ProductRepository();   // 🔹 Repo nesnesi bir kere oluşturuldu
        ProductService productService = new ProductService(productRepository);

        Product product1 = new Product();
        product1.setName("Aksesuar Mum");
        product1.setId(1);
        product1.setStock(12);
        product1.setPrice(100.00);
        productService.addProduct(product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Dekor Saat");
        product2.setStock(0);
        product2.setPrice(300.00);
        productService.addProduct(product2);

        productService.stockCheck(1);


        // Sipariş işlemleri
        OrderService orderService = new OrderService(new OrderRepository(), productRepository); // 🔹 Aynı repo paylaşıldı

        List<OrderItem> items = new ArrayList<>();

        items.add(new OrderItem(1, 1, 15000));
        items.add(new OrderItem(2, 2, 500));

        orderService.createOrder(1001, 1, items);
    }
}
