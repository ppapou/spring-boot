package com.example.data.backendapi.repo;

import java.util.List;

import com.example.data.backendapi.dao.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
