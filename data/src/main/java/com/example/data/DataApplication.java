package com.example.data;

/**
 * Create app that should support create, read, update and delete operations for some entity
 * Use Spring Data module
 * Don't use Spring Data REST starter
 */

import com.example.data.backendapi.dao.Customer;
import com.example.data.backendapi.repo.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataApplication {

	private static final Logger log = LoggerFactory.getLogger(DataApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DataApplication.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info(customer.toString());

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
		};
	}

}
