package com.invoicemanagement.service;

import com.invoicemanagement.service.classes.User;
import com.invoicemanagement.repositories.UserRepository;
import com.invoicemanagement.repositories.entities.UserDTO;
import com.invoicemanagement.service.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserContainer {
    private final UserRepository userRepository;
    @Autowired
    public UserContainer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean createUser(UserDTO userdto) {
        User user = UserMapper.userDTOToUser(userdto);
        if (user.validateUser()) {
            user.setUuid();
            userdto = UserMapper.userToUserDTO(user);
            try{
                userRepository.save(userdto);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public Iterable<UserDTO> getUsers(){
        return userRepository.findAll();
    }
}
