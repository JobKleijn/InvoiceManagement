package com.invoicemanagement.service.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class Invoice {
    private UUID uuid;
    private String invoiceNumber;
    private String invoiceDate;
    private String dueDate;
    private List<Product> products;

    public Invoice(UUID uuid, String invoiceNumber, String invoiceDate, String dueDate, List<Product> products) {
        this.uuid = uuid;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.products = products;
    }

    public void setUuid() {
        this.uuid = UUID.randomUUID();
    }
}
