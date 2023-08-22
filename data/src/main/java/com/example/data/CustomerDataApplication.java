package com.example.data;

/**
 * Create app that should support create, read, update and delete operations for some entity
 * Use Spring Data module
 * Don't use Spring Data REST starter
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CustomerDataApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerDataApplication.class);
	}
}
