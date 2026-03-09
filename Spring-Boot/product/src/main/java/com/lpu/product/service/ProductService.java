package com.lpu.product.service;

import org.springframework.stereotype.Service;
import com.lpu.product.entity.Product;
import com.lpu.product.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	public Product findById(int id) {
		 return productRepository.findById(id).orElse(null);
	 }
	 public Product save(Product p) {
		 return productRepository.save(p);
	 }
}
