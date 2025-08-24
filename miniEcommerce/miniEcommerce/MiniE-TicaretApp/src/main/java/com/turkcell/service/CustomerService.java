package com.turkcell.service;

import com.turkcell.entity.Customer;
import com.turkcell.repository.CustomerRepository;
import com.turkcell.repository.IRepository;

public class CustomerService {

    //DI ile CustomerRepository'i kullanacağız bunu yaparken de implemente ettiği interface'in değişkenini yaratacağız.
    IRepository<Customer> customerRepository;

    public CustomerService(IRepository<Customer> customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    public void customerRegistration(Customer customer){

        if (customer.getId() > 0)
        {
            customerRepository.addRegister(customer);
        }
        else
        {
            System.out.println("Geçersiz kullanıcı id'si.");
        }
    }

    public void findCustomer(int id){

        customerRepository.findById(id);

    }

}
