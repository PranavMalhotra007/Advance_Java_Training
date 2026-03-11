package com.lpu.ecommerce.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.ecommerce.Entity.Orders;
import com.lpu.ecommerce.Entity.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
@Component
public class OrdersDao {
	@Autowired
	private EntityManagerFactory emf;
		public void saveOrder(Orders o) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(o);
			et.commit();
			em.close();
		}
		public Orders findOrder(int id) {
			EntityManager em = emf.createEntityManager();
			Orders o = em.find(Orders.class, id);
			em.close();
			return o;
		}
		public void addProduct(Products p, int id) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Orders o = em.find(Orders.class, id);
			et.begin();
			o.getProductList().add(p);
			em.merge(o);
			et.commit();
			em.close();
		}
		public void deleteOrder(int id) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Orders o = em.find(Orders.class, id);
			et.begin();
			em.remove(o);
			et.commit();
			em.close();
		}
}