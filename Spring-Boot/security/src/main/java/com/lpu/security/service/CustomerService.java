package com.lpu.security.service;

import org.springframework.stereotype.Service;

import com.lpu.security.entity.Customer;
import com.lpu.security.repository.CustomerRepository;
@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	public Customer register(Customer c) {
		return customerRepository.save(c);
	}
}
