package com.lpu.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.product.entity.Product;
import com.lpu.product.service.ProductService;
@RestController
@RequestMapping("/product")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	@GetMapping("/find/{id}")
	public Product findByid(@PathVariable int id) {
		return productService.findById(id);
	}
	@PostMapping("/save")
	public Product savePayment(@RequestBody Product p) {
		return productService.save(p);
	}
}
