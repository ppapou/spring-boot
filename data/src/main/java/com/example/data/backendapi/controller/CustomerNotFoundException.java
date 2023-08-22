package com.example.data.backendapi.controller;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(Long id) {
        super("Could not find customer " + id);
    }
}
