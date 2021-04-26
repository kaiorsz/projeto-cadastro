package com.github.kaiorsz.backendmax.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Seller {
    private String name;
    @Id
    private String code;

    public Seller(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Seller() {

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
