package com.invoicemanagement.repositories;


import com.invoicemanagement.repositories.entities.UserDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserDTO, UUID> {
}

