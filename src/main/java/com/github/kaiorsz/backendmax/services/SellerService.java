package com.github.kaiorsz.backendmax.services;

import com.github.kaiorsz.backendmax.entities.Seller;
import com.github.kaiorsz.backendmax.repositories.SellerRepository;
import org.springframework.stereotype.Component;

@Component
public class SellerService {
    private SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
    public Seller saveNewSeller (String name, String code){
        if(sellerRepository.existsById(code)) throw new RuntimeException();
        else{
            Seller s = new Seller();
            s.setName(name);
            s.setCode(code);
            return sellerRepository.save(s);
        }
    }
}
