package com.invoicemanagement.controllers;

import com.invoicemanagement.repositories.entities.UserDTO;
import com.invoicemanagement.service.UserContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/users/{uuid}")
    public UserDTO getUser(@PathVariable UUID uuid) {
        return userContainer.getUser(uuid);
    }
    @PutMapping("/users")
    public boolean updateUser(@RequestBody UserDTO userdto) {
        return userContainer.updateUser(userdto);
    }
}
