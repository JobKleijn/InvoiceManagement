package com.invoicemanagement.application;

import com.invoicemanagement.repositories.entities.UserDTO;
import com.invoicemanagement.service.UserContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class InvoiceManagementApplicationTests {


    private final UserContainer userContainer;

    @Autowired
    public InvoiceManagementApplicationTests(UserContainer userContainer) {
        this.userContainer = userContainer;
    }

    @Test
    void createUserTest() {
        UserDTO userdto = new UserDTO();
        userdto.setEmail("test@test.com");
        userdto.setFirstname("Test");
        userdto.setLastname("Test");
        assertTrue(userContainer.createUser(userdto));
    }

    //Get user test
    @Test
    void getUserTest() {
        UserDTO userdto = new UserDTO();
        userdto.setEmail("test@test.com");
        userdto.setFirstname("Test");
        userdto.setLastname("Test");
        userContainer.createUser(userdto);
        assertNotNull(userContainer.getUser(userdto.getUuid()));
    }

    //Test all fields for user
    @Test
    void createUserTestAllFields() {

        UserDTO userdto = new UserDTO();
        userdto.setEmail("test@test.com");
        userdto.setFirstname("Test");
        userdto.setLastname("Test");
        userContainer.createUser(userdto);
        UserDTO result = userContainer.getUser(userdto.getUuid());
        assertNotNull(result.getUuid());
        assertNotNull(result.getEmail());
        assertNotNull(result.getFirstname());
        assertNotNull(result.getLastname());
    }
}
