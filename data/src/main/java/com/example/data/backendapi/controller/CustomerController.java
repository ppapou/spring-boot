package com.example.data.backendapi.controller;

import com.example.data.backendapi.dto.Customer;
import com.example.data.backendapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Long id) {

        return customerService.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }
}