package com.example.data.backendapi.service;

import com.example.data.backendapi.dao.CustomerRepository;
import com.example.data.backendapi.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.util.Optional;

@Scope("singleton")
public class CustomerService {

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    private final CustomerRepository repository;

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

    /**
     *
     * @param id
     * @return Client by id number
     */
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Remove client record from repository
     * @param customer
     */
    public void delete(Customer customer) {
        repository.delete(customer);
    }
}
