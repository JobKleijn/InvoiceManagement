package com.invoicemanagement.service.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Setter
@Getter
public class Product {
    private UUID uuid;
    private String description;
    private double rate;
    private double quantity;

    public Product(UUID uuid, String description, double rate, double quantity) {
        this.description = description;
        this.rate = rate;
        this.quantity = quantity;
    }
    public void setUuid() {
        this.uuid = UUID.randomUUID();
    }
}
