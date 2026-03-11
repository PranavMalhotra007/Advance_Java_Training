package com.lpu.security.service;



import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PostAuthorize("retrunObject.name == authentication.name")
	public String deleteCustomer(int id) {
		customerRepository.deleteById(id);
		return "deleted";
	}
	@PostAuthorize("retrunObject.name == authentication.name")
	public Customer findbyIDCustomer(int id) {
		return customerRepository.findById(id).get();
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
}
