package com.invoicemanagement.service.Mappers;

import com.invoicemanagement.service.Classes.User;
import com.invoicemanagement.repositories.entities.UserDTO;

public class UserMapper {
    public static User UserDTOToUser(UserDTO userdto) {
        return new User(userdto.getUuid(), userdto.getEmail(), userdto.getFirstname(), userdto.getLastname());
    }

    public static UserDTO UserToUserDTO(User user) {
        UserDTO userdto = new UserDTO();
        userdto.setUuid(user.getUuid());
        userdto.setEmail(user.getEmail());
        userdto.setFirstname(user.getFirstname());
        userdto.setLastname(user.getLastname());
        return userdto;
    }
}
