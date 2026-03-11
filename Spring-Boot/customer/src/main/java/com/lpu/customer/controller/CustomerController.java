package com.lpu.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.customer.entity.Customer;
import com.lpu.customer.entity.Product;
import com.lpu.customer.service.CustomerService;
import com.lpu.customer.service.ProductFeignClient;
@RestController
@RequestMapping("/user")
public class CustomerController {
	@Autowired
	private ProductFeignClient proClient;
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	@GetMapping("/product")
	public List<Product> productApi() {
		return proClient.getProductData();
	}
	@GetMapping("/product/{id}")
	public Product findByidProduct(@PathVariable int id) {
		return proClient.findByid(id);
	}
	@PostMapping("/product/save")
	public Product saveProduct(@RequestBody Product p) {
		return proClient.savePayment(p);
	}
	@GetMapping("/find/{id}")
	public Customer findByid(@PathVariable int id) {
		return customerService.findById(id);
	}
	@PostMapping("/save")
	public Customer saveCustomer(@RequestBody Customer c) {
		return customerService.save(c);
	}
	@GetMapping("/data")
	public String data() {
		return "data is saved";
	}
	@GetMapping("/find/all")
	public List<Customer> findAll(){
		return customerService.findAll();
	}
}
