package com.lpu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

@Component
public class EmployeeDao {
	@Autowired
	private EntityManagerFactory emf;
	public void saveEmployee(Employee e) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(e);
		et.commit();
		em.close();
	}
	public void deleteEmployee(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Employee e = em.find(Employee.class, id);
		et.begin();
		em.remove(e);
		et.commit();
		em.close();
	}
	public void updateEmployee(int id, String name,String phone, String email) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Employee e = em.find(Employee.class, id);
		e.setName(name);
		e.setPhone(phone);
		e.setEmail(email);
		et.begin();
		em.merge(e);
		et.commit();
		em.close();
	}
	public List<Employee> getAllEmployee(){
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select e from Employee e");
		List<Employee>employees = query.getResultList(); 
		em.close();
		return employees;
	}
	public Employee findEmployee(int id) {
		EntityManager em = emf.createEntityManager();
		Employee e = em.find(Employee.class, id);
		em.close();
		// TODO Auto-generated method stub
		return e;
	}
}
