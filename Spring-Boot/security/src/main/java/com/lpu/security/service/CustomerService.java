package com.lpu.security.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lpu.security.entity.Customer;
import com.lpu.security.repository.CustomerRepository;
@Service
public class CustomerService {
	private final CustomerRepository customerRepository;
	private final PasswordEncoder passwordEncoder;
	
	public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
		super();
		this.customerRepository = customerRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public Customer register(Customer c) {
		String encodedPassword = passwordEncoder.encode(c.getPassword());
		String role = "ROLE_"+c.getRole().toUpperCase();
		c.setRole(role);
		c.setPassword(encodedPassword);
		return customerRepository.save(c);
	}
}
