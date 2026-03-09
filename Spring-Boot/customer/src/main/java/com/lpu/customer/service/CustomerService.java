package com.lpu.customer.service;

import org.springframework.stereotype.Service;

import com.lpu.customer.entity.Customer;
import com.lpu.customer.repository.CustomerRepository;
@Service
public class CustomerService {
 private final CustomerRepository customerRepository;

 public CustomerService(CustomerRepository customerRepository) {
	super();
	this.customerRepository = customerRepository;
 }
 public Customer findById(int id) {
	 return customerRepository.findById(id).orElse(null);
 }
 public Customer save(Customer c) {
	 return customerRepository.save(c);
 }
}
