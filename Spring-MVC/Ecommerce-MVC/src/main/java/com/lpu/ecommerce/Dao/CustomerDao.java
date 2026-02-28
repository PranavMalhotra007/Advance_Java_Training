package com.lpu.ecommerce.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.ecommerce.Entity.Customer;
import com.lpu.ecommerce.Entity.Orders;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class CustomerDao {
	@Autowired
	private EntityManagerFactory emf;
		public void saveCustomer(Customer c) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(c);
			et.commit();
			em.close();
		}
		public Customer findCustomer(int id) {
			EntityManager em = emf.createEntityManager();
			Customer c = em.find(Customer.class, id);
			em.close();
			return c;
		}
		public void addOrder(Orders o, int id) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Customer c = em.find(Customer.class, id);
			et.begin();
			c.getOrderList().add(o);
			em.merge(c);
			et.commit();
			em.close();
		}
		public void deleteCustomer(int id) {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Customer c = em.find(Customer.class, id);
			et.begin();
			em.remove(c);
			et.commit();
			em.close();
		}
		public Customer loginCustomer(int id, String password) {
			EntityManager em = emf.createEntityManager();
			Customer c = em.find(Customer.class, id);
			em.close();

			if (c != null && c.getPassword().equals(password)) {
				return c;
			} else {
				return null;
			}
		}
}