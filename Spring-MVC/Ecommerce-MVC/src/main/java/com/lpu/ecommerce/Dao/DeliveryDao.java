package com.lpu.ecommerce.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.ecommerce.Entity.Delivery;
import com.lpu.ecommerce.Entity.Orders;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
@Component
public class DeliveryDao {
	@Autowired
	private EntityManagerFactory emf;
		public void saveDelivery(Delivery d) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(d);
			et.commit();
			em.close();
		}
		public Delivery findDelivery(int id) {
			EntityManager em = emf.createEntityManager();
			Delivery d = em.find(Delivery.class, id);
			em.close();
			return d;
		}
		public void addOrder(Orders o, int id) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Delivery d = em.find(Delivery.class, id);
			et.begin();
			d.getOrderList().add(o);
			em.merge(d);
			et.commit();
			em.close();
		}
		public void deleteDelivery(int id) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Delivery d = em.find(Delivery.class, id);
			et.begin();
			em.remove(d);
			et.commit();
			em.close();
		}
}