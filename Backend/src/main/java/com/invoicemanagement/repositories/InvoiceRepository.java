package com.invoicemanagement.repositories;

import com.invoicemanagement.repositories.entities.InvoiceDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InvoiceRepository extends CrudRepository<InvoiceDTO, UUID> {
}
