package com.invoicemanagement.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.invoicemanagement.service", "com.invoicemanagement.controllers", "com.invoicemanagement.repositories"})
@EnableJpaRepositories("com.invoicemanagement.repositories")
@EntityScan("com.invoicemanagement.repositories.entities")
public class InvoiceManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvoiceManagementApplication.class, args);
    }

}
