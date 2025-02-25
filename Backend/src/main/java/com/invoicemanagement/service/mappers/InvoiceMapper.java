package com.invoicemanagement.service.mappers;

import com.invoicemanagement.repositories.entities.InvoiceDTO;
import com.invoicemanagement.service.classes.Invoice;
import com.invoicemanagement.service.enums.Status;

public class InvoiceMapper {
    private InvoiceMapper(){}
    public static Invoice invoiceDTOToInvoice(InvoiceDTO invoicedto) {
        return new Invoice(invoicedto.getUuid(), invoicedto.getInvoiceNumber(), invoicedto.getInvoiceDate(), invoicedto.getDueDate(), Status.values()[invoicedto.getStatus()], ProductMapper.productDTOToProduct(invoicedto.getProducts()));
    }
    public static InvoiceDTO invoiceToInvoiceDTO(Invoice invoice) {
        InvoiceDTO invoicedto = new InvoiceDTO();
        invoicedto.setUuid(invoice.getUuid());
        invoicedto.setInvoiceNumber(invoice.getInvoiceNumber());
        invoicedto.setInvoiceDate(invoice.getInvoiceDate());
        invoicedto.setDueDate(invoice.getDueDate());
        invoicedto.setStatus(invoice.getStatus().ordinal());
        invoicedto.setProducts(ProductMapper.productToProductDTO(invoice.getProducts()));
        return invoicedto;
    }
}
