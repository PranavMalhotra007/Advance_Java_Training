package com.lpu.ecommerce.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.ecommerce.Entity.Categories;
import com.lpu.ecommerce.Entity.Orders;
import com.lpu.ecommerce.Entity.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
@Component
public class ProductsDao {
	@Autowired
	private EntityManagerFactory emf;
		public void saveProduct(Products p) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(p);
			et.commit();
			em.close();
		}
		public Products findProducts(int id) {
			EntityManager em = emf.createEntityManager();
			Products p = em.find(Products.class, id);
			em.close();
			return p;
		}
		public void addOrders(Orders o, int id) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Products p = em.find(Products.class, id);
			et.begin();
			p.getOrderList().add(o);
			em.merge(p);
			et.commit();
			em.close();
		}
		public void updateCategory(Categories c, int id) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Products p = em.find(Products.class, id);
			et.begin();
			p.setCategory(c);
			em.merge(p);
			et.commit();
			em.close();
		}
		public void deleteProduct(int id) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Products p = em.find(Products.class, id);
			et.begin();
			em.remove(p);
			et.commit();
			em.close();
		}
}