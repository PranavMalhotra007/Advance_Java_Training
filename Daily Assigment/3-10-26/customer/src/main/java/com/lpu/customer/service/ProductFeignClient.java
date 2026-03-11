package com.lpu.customer.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lpu.customer.entity.Product;



@FeignClient("PRODUCT")
public interface ProductFeignClient {
	@GetMapping("/product/data")
	public List<Product> getProductData();
	@GetMapping("/product/find/{id}")
	public Product findByid(@PathVariable int id) ;
	@PostMapping("/product/save")
	public Product savePayment(@RequestBody Product p) ;
}
