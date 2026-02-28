package com.lpu.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.ecommerce.Dao.ProductsDao;
import com.lpu.ecommerce.Entity.Categories;
import com.lpu.ecommerce.Entity.Orders;
import com.lpu.ecommerce.Entity.Products;

@Component
public class ProductsService {
	@Autowired
	private ProductsDao productsDao;
		public void saveProduct(Products p) {
			productsDao.saveProduct(p);
		}
		public Products findProducts(int id) {
			return productsDao.findProducts(id);
		}
		public void addOrders(Orders o, int id) {
			productsDao.addOrders(o, id);
		}
		public void updateCategory(Categories c, int id) {
			productsDao.updateCategory(c, id);
		}
		public void deleteProduct(int id) {
			productsDao.deleteProduct(id);
		}
}