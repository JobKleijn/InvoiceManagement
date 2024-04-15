package com.invoicemanagement.service;

import com.invoicemanagement.service.Classes.User;
import com.invoicemanagement.repositories.IUserRepository;
import com.invoicemanagement.repositories.entities.UserDTO;
import com.invoicemanagement.service.Mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserContainer {
    private final IUserRepository userRepository;
    @Autowired
    public UserContainer(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean createUser(UserDTO userdto) {
        User user = UserMapper.UserDTOToUser(userdto);
        if (user.validateUser()) {
            user.setUuid();
            userdto = UserMapper.UserToUserDTO(user);
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
