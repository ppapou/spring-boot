package com.example.data.backendapi.service;

import com.example.data.backendapi.dao.CustomerRepository;
import com.example.data.backendapi.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.util.Optional;

@Scope("singleton")
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    /**
     * Save client record in the repository
     * @param customer
     */
    public void save(Customer customer) {
        repository.save(customer);
    }

    /**
     *
     * @return ALL records from the repository
     */
    public Iterable<Customer> getAll() {
        return repository.findAll();
    }

    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

}
