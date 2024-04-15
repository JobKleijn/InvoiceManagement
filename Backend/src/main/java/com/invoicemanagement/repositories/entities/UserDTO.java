package com.invoicemanagement.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Table(name = "[USER]")
@Entity
public class UserDTO {
    @Id
    private UUID uuid;
    @Column(unique = true)
    private String email;
    private String firstname;
    private String lastname;

}
