package com.github.kaiorsz.backendmax.services;

import com.github.kaiorsz.backendmax.entities.Client;
import com.github.kaiorsz.backendmax.entities.Seller;
import com.github.kaiorsz.backendmax.repositories.ClientRepository;
import com.github.kaiorsz.backendmax.repositories.SellerRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientService {
    private ClientRepository clientRepository;
    private SellerRepository sellerRepository;

    public ClientService(ClientRepository clientRepository, SellerRepository sellerRepository) {
        this.clientRepository = clientRepository;
        this.sellerRepository = sellerRepository;
    }

    public Client saveNewClient (String name, String code, String codeSeller){
        Seller seller = sellerRepository.findById(codeSeller).orElse(null);
        if(clientRepository.existsById(code)) throw new RuntimeException();
        else{
            Client client = new Client(name, code, seller);
            return clientRepository.save(client);
        }
    }
}
