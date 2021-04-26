package com.github.kaiorsz.backendmax.controllers;

import com.github.kaiorsz.backendmax.entities.Product;
import com.github.kaiorsz.backendmax.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping("/product")
    @PostMapping
    public Product product (@RequestBody ProductPayload productPayload){
        return productService.saveNewProduct(productPayload.getName(), productPayload.getCode());
    }

    public static class ProductPayload {
        private String name;
        private String code;

        public ProductPayload(String name, String code) {
            this.name = name;
            this.code = code;
        }

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
    }
}
