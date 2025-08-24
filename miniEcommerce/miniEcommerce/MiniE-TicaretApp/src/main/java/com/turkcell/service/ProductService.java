package com.turkcell.service;

import com.turkcell.entity.Customer;
import com.turkcell.entity.Product;
import com.turkcell.repository.IRepository;
import com.turkcell.repository.ProductRepository;

public class ProductService {
    IRepository<Product> productRepository;


    public ProductService(IRepository<Product> productRepository){this.productRepository = productRepository;}

    public void addProduct(Product product)
    {
            if(product.getPrice()>=10)
            {
                productRepository.addRegister(product);
            }
            else {
                System.out.println("Lütfen 10.00tl'den yüksek bir tutar giriniz.");
            }
    }

    public void stockCheck(int id) {

        Product productIslem = productRepository.findById(id); //findById geriye bir nesne dönüyor. Bu nesneyi tutacak bir değişkene ihtiyacımız var.

        if (productIslem != null) {

            if (productIslem.getStock() > 0) {
                System.out.println(productIslem.getName() + " adlı üründen kalan stock : " + productIslem.getStock());
            } else {
                System.out.println("Bu ürün stokta bulunmamaktadır.");
            }
        }

    }
}
