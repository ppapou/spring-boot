package com.example.data.backendapi.controller;

import com.example.data.backendapi.dto.Customer;
import com.example.data.backendapi.service.CustomerService;
import com.nimbusds.oauth2.sdk.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public  CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/{id}")
    public Customer one(@PathVariable Long id) {

        return customerService.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PostMapping("/customers/save")
    void save(Customer customer) {
        customerService.save(customer);
    }

    @PostMapping("customers/delete")
    void delete(Customer customer) {
        customerService.delete(customer);
    }

}