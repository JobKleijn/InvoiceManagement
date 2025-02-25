package com.invoicemanagement.service;

import com.invoicemanagement.repositories.UserRepository;
import com.invoicemanagement.repositories.entities.UserDTO;
import com.invoicemanagement.service.classes.User;
import com.invoicemanagement.service.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserContainer {
    private final UserRepository userRepository;
    @Autowired
    public UserContainer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean createUser(UserDTO userDTO) {
        User user = UserMapper.userDTOToUser(userDTO);
        if (user.validateUser()) {
            user.setUuid();
            userDTO = UserMapper.userToUserDTO(user);
            try {
                userRepository.save(userDTO);
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

    public UserDTO getUser(UUID uuid) {
        return userRepository.findById(uuid).orElse(null);
    }

    public boolean updateUser(UserDTO userdto) {
        try {
            userRepository.save(userdto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
