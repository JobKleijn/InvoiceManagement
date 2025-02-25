package com.invoicemanagement.controllers;

import com.invoicemanagement.repositories.entities.InvoiceDTO;
import com.invoicemanagement.service.InvoiceContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {
    private InvoiceContainer invoiceContainer;
    @Autowired
    public InvoiceController(InvoiceContainer invoiceContainer) {
        this.invoiceContainer = invoiceContainer;
    }
    @PostMapping("/invoices")
    public boolean createInvoice(@RequestBody InvoiceDTO invoicedto) {
        return invoiceContainer.createInvoice(invoicedto);
    }
    @GetMapping("/invoices")
    public Iterable<InvoiceDTO> getInvoices() {
        return invoiceContainer.getInvoices();
    }
}
