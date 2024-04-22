package com.invoicemanagement.service;

import com.invoicemanagement.repositories.InvoiceRepository;
import com.invoicemanagement.repositories.entities.InvoiceDTO;
import com.invoicemanagement.service.classes.Invoice;
import com.invoicemanagement.service.classes.Product;
import com.invoicemanagement.service.mappers.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceContainer {
    private final InvoiceRepository invoiceRepository;
    @Autowired
    public InvoiceContainer(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Iterable<InvoiceDTO> getInvoices(){
        return invoiceRepository.findAll();
    }

    public boolean createInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoice = InvoiceMapper.invoiceDTOToInvoice(invoiceDTO);
        invoice.setUuid();
        invoice.getProducts().forEach(Product::setUuid);
        invoiceDTO = InvoiceMapper.invoiceToInvoiceDTO(invoice);
        try{
            invoiceRepository.save(invoiceDTO);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteInvoice(InvoiceDTO invoiceDTO) {
        try{
            invoiceRepository.delete(invoiceDTO);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateInvoice(InvoiceDTO invoiceDTO) {
        try{
            invoiceRepository.save(invoiceDTO);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
