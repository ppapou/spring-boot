package com.example.data.backendapi.controller;

import com.example.data.backendapi.dto.Customer;
import com.example.data.backendapi.service.CustomerService;
import jdk.jfr.ContentType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public  CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/{id}")
    public Customer one(@PathVariable Long id) {

        return customerService.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/customers/{id}")
    public Customer save(@RequestBody Customer customer, @PathVariable Long id) {
        return customerService.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    void delete(@PathVariable Long id) {
        customerService.delete(id);
    }

}