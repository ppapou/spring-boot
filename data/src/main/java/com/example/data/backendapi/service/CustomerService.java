package com.example.data.backendapi.service;

import com.example.data.backendapi.dao.CustomerRepository;
import com.example.data.backendapi.dao.OAuth;
import com.example.data.backendapi.dto.Customer;
import com.example.data.backendapi.user.CustomUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

//TODO: the repository will be replaced
@Service
public class CustomerService implements UserDetailsService {

    public CustomerService(CustomerRepository repository, OAuth oAuth) {
        this.oAuth = oAuth;
        this.repository = repository;

    }

    private final CustomerRepository repository;
    private final OAuth oAuth;

    /**
     * Save client record in the repository
     * @param customer
     */
    public Customer save(Customer customer) {
        return repository.save(customer);
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
     * @param id
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer userEntity = null;
        try {
            userEntity = oAuth.getUserDetails(username);
            return new CustomUser(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
    }
}
