package com.invoicemanagement.controllers;

import com.invoicemanagement.service.UserContainer;
import com.invoicemanagement.repositories.entities.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserContainer userContainer;

    @Autowired
    public UserController(UserContainer userContainer) {
        this.userContainer = userContainer;
    }

    @PostMapping("/users")
    public boolean createUser(@RequestBody UserDTO userdto) {
        return userContainer.createUser(userdto);
    }

    @GetMapping("/users")
    public Iterable<UserDTO> getUsers() {
        return userContainer.getUsers();
    }


}
