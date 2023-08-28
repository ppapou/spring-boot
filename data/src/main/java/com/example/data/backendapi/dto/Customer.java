package com.example.data.backendapi.dto;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Client's objects with personal information
 */
@Table(name = "customer")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    private Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Customer))
            return false;
        Customer customer = (Customer) o;
        return Objects.equals(this.id, customer.id) && Objects.equals(this.firstName, customer.firstName);
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public  Long getId(){return this.id;}
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() { return password;}

    public void setPassword(String password) {this.password = password;}

    public String getUsername() {return userName;}

    public void setUsername(String username) {this.userName = username;}

    public Collection<GrantedAuthority> getGrantedAuthoritiesList() {return grantedAuthoritiesList;}

    public void setGrantedAuthoritiesList(Collection<GrantedAuthority> grantedAuthoritiesList) {this.grantedAuthoritiesList = grantedAuthoritiesList;}
}