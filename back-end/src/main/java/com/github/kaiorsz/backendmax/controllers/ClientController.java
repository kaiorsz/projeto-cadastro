package com.github.kaiorsz.backendmax.controllers;

import com.github.kaiorsz.backendmax.entities.Client;
import com.github.kaiorsz.backendmax.entities.Seller;
import com.github.kaiorsz.backendmax.services.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/client")
    @PostMapping
    public Client client (@RequestBody ClientPayload clientPayload){
        return clientService.saveNewClient(clientPayload.getName(), clientPayload.getCode(), clientPayload.getCodeSeller());
    }

    public static class ClientPayload{
        private String name;
        private String codeSeller;
        private String code;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCodeSeller() {
            return codeSeller;
        }

        public void setCodeSeller(String codeSeller) {
            this.codeSeller = codeSeller;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public ClientPayload(String name, String codeSeller, String code) {
            this.name = name;
            this.codeSeller = codeSeller;
            this.code = code;
        }
    }
}
