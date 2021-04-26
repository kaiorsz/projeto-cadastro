package com.github.kaiorsz.backendmax.entities;

import org.aspectj.bridge.Message;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Client {
    private String name;
    @Id
    private String code;
    @JoinColumn (name = "CODE_SELLER", nullable = false)
    @ManyToOne
    private Seller seller;

    public String getName() {
        return name;
    }
    public Client (){
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Client(String name, String code, Seller seller) {
        this.name = name;
        this.code = code;
        this.seller = seller;
    }
}
