package com.lpu.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.customer.entity.Customer;
import com.lpu.customer.service.CustomerService;
@RestController
@RequestMapping("/user")
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	@GetMapping("/find/{id}")
	public Customer findByid(@PathVariable int id) {
		return customerService.findById(id);
	}
	@PostMapping("/save")
	public Customer saveCustomer(@RequestBody Customer c) {
		return customerService.save(c);
	}
}
