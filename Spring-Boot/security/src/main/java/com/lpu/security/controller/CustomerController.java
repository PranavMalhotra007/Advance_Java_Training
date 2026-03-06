package com.lpu.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.security.entity.Customer;
import com.lpu.security.service.CustomerService;

@RestController
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody Customer c) {
		return customerService.register(c);
	}
	@GetMapping("/pubilc")
	public String homepage() {
		return "public page";
	}
	@GetMapping("/account")
	public String accountPage() {
		return "account page";
	}
}