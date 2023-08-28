package com.example.data.backendapi.service;

import com.example.data.backendapi.dao.CustomerRepository;
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

    public CustomerService(CustomerRepository oAuth) {
        this.oAuth = oAuth;
   }
    private final CustomerRepository oAuth;

    /**
     * Save client record in the repository
     * @param customer
     */
    public Customer save(Customer customer) {
        return oAuth.save(customer);
    }
    /**
     *
     * @param id
     * @return Client by id number
     */
    public Optional<Customer> findById(Long id) {
        return oAuth.findById(id);
    }

    /**
     * Remove client record from repository
     * @param id
     */
    public void delete(Long id) {
        oAuth.deleteById(id);
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
