package com.github.kaiorsz.backendmax.services;

import com.github.kaiorsz.backendmax.entities.Product;
import com.github.kaiorsz.backendmax.repositories.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveNewProduct (String name, String code){
        if(productRepository.existsById(code)) throw new RuntimeException();
        else{
            return productRepository.save(new Product(name, code));
        }
    }
}
