package com.turkcell.repository;

import com.turkcell.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements IRepository<Customer> {

    List<Customer> customers = new ArrayList<>();


    @Override
    public void addRegister(Customer customer) {

        customers.add(customer);
        System.out.println("Yeni müşteri : " + customer.getName() + " sisteme başarıyla eklendi.");
    }


    @Override
    public Customer findById(int id) {
        for (Customer customer : customers) {

            if (customer.getId() == id)
            {
                System.out.println(customer.getId() +" Numaralı müşteri bulundu: " + customer.getName());
                return customer;

            }
        }
        System.out.println("Bu id'e ait müşteri bulunamadı.");
        return null;
    }

}
