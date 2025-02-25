package com.invoicemanagement.service.mappers;

import com.invoicemanagement.repositories.entities.ProductDTO;
import com.invoicemanagement.service.classes.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    private ProductMapper(){}
    public static List<Product> productDTOToProduct(List<ProductDTO> productDTOs) {
        List<Product> products = new ArrayList<>();
        for (ProductDTO productdto : productDTOs) {
            products.add(new Product(productdto.getUuid(), productdto.getDescription(), productdto.getRate(), productdto.getQuantity()));
        }
        return products;
    }

    public static List<ProductDTO> productToProductDTO(List<Product> products) {
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            ProductDTO productdto = new ProductDTO();
            productdto.setUuid(product.getUuid());
            productdto.setDescription(product.getDescription());
            productdto.setRate(product.getRate());
            productdto.setQuantity(product.getQuantity());
            productDTOs.add(productdto);
        }
        return productDTOs;
    }
}
