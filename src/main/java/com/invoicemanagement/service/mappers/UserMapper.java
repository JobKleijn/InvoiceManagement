package com.invoicemanagement.service.mappers;

import com.invoicemanagement.service.classes.User;
import com.invoicemanagement.repositories.entities.UserDTO;

public class UserMapper {
    private UserMapper(){}
    public static User userDTOToUser(UserDTO userdto) {
        return new User(userdto.getUuid(), userdto.getEmail(), userdto.getFirstname(), userdto.getLastname());
    }

    public static UserDTO userToUserDTO(User user) {
        UserDTO userdto = new UserDTO();
        userdto.setUuid(user.getUuid());
        userdto.setEmail(user.getEmail());
        userdto.setFirstname(user.getFirstname());
        userdto.setLastname(user.getLastname());
        return userdto;
    }
}
