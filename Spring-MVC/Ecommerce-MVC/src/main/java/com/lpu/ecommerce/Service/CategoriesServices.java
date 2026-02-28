package com.lpu.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.ecommerce.Dao.CategoriesDao;
import com.lpu.ecommerce.Entity.Categories;
import com.lpu.ecommerce.Entity.Products;


@Component
public class CategoriesServices {
	@Autowired
	private CategoriesDao categoriesDao;
	public void saveCategory(Categories c) {
		categoriesDao.saveCategory(c);
	}
	public Categories findCategory(int id) {
		return categoriesDao.findCategory(id);
	}
	public void addProduct(Products p, int id) {
		categoriesDao.addProduct(p, id);
	}
}