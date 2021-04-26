package com.github.kaiorsz.backendmax.repositories;

import com.github.kaiorsz.backendmax.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, String> {

}
