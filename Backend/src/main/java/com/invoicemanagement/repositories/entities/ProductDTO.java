package com.invoicemanagement.repositories.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Table(name = "product")
@Entity
public class ProductDTO {
    @Id
    private UUID uuid;
    private String description;
    private double rate;
    private double quantity;
}
