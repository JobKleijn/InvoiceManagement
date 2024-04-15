package com.invoicemanagement.service.Classes;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class User {
    private UUID uuid;
    private String email;
    private String firstname;
    private String lastname;

    public User(UUID uuid, String email, String firstname, String lastname) {
        this.uuid = uuid;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setUuid() {
        this.uuid = UUID.randomUUID();
    }

    //Validates the user object
    public boolean validateUser() {
        if (this.email == null || this.email.isEmpty()) {
            return false;
        }
        if (this.firstname == null || this.firstname.isEmpty()) {
            return false;
        }
        if (this.lastname == null || this.lastname.isEmpty()) {
            return false;
        }
        return true;
    }
}
