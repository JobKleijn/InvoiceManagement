package com.invoicemanagement.repositories.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Table(name = "invoice")
@Entity
public class InvoiceDTO {
    @Id
    private UUID uuid;
    private String invoiceNumber;
    private String invoiceDate;
    private String dueDate;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_invoice",
            joinColumns = @JoinColumn(name = "product_uuid", referencedColumnName = "uuid"),
            inverseJoinColumns = @JoinColumn(name = "invoice_uuid",
                    referencedColumnName = "uuid"))
    private List<ProductDTO> products;
}
