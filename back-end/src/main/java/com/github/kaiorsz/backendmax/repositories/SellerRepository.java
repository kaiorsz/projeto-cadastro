package com.github.kaiorsz.backendmax.repositories;

import com.github.kaiorsz.backendmax.entities.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository <Seller, String> {
}
