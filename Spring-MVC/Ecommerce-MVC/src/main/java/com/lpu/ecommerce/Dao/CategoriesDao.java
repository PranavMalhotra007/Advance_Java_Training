package com.lpu.ecommerce.Dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.ecommerce.Entity.Categories;
import com.lpu.ecommerce.Entity.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class CategoriesDao {
	@Autowired
	private EntityManagerFactory emf;
		public void saveCategory(Categories c) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(c);
			et.commit();
			em.close();
		}
		public Categories findCategory(int id) {
			EntityManager em = emf.createEntityManager();
			Categories c = em.find(Categories.class, id);
			em.close();
			return c;
		}
		public void addProduct(Products p, int id) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Categories c = em.find(Categories.class, id);
			et.begin();
			c.getProductList().add(p);
			em.merge(c);
			et.commit();
			em.close();
		}
}