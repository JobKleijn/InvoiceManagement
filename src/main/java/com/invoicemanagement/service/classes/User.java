package com.invoicemanagement.service.classes;

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
        boolean result = this.email != null && !this.email.isEmpty();
        if (this.firstname == null || this.firstname.isEmpty()) {
            result = false;
        }
        if (this.lastname == null || this.lastname.isEmpty()) {
            result = false;
        }
        return result;
    }
}
