package com.example.data.backendapi.dao;

import java.util.List;

import com.example.data.backendapi.dto.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Logic for customer's data
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
