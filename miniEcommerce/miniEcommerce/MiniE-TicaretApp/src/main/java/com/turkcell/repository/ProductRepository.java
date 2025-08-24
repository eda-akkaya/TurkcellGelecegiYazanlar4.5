package com.turkcell.repository;


import com.turkcell.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IRepository<Product> {

    List<Product> products = new ArrayList<>();

    @Override
    public void addRegister(Product product) {
        products.add(product);
        System.out.println(product.getName() + " ürünü başarıyla eklendi.");
    }

    @Override
    public Product findById(int id)
    {

                for (Product product : products) {
                    if (product.getId() == id) {
                        return product;
                    }
                }
                System.out.println("Sistemde bu id'e ait bir ürün kaydı bulunamadı.");
                return null;
    }

}
