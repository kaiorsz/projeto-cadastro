package com.github.kaiorsz.backendmax.controllers;

import com.github.kaiorsz.backendmax.entities.Seller;
import com.github.kaiorsz.backendmax.services.SellerService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class SellerController {
    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @RequestMapping("/seller")
    @PostMapping
    public Seller seller (@RequestBody SellerPayload sellerPayload){
        return sellerService.saveNewSeller(sellerPayload.getName(), sellerPayload.getCode());
    }

    public static class SellerPayload {
        private String name;
        private String code;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public SellerPayload(String name, String code) {
            this.name = name;
            this.code = code;
        }
    }
}
