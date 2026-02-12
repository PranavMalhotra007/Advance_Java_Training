package com.lpu;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class EmployeesServices{
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public void findById(int id) {
		Employees employee = em.find(Employees.class, id);
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getPhone());
	}
	
	public void updatePhone(int id, long phone) {
		Employees employee = em.find(Employees.class, id);
		employee.setPhone(phone);
		et.begin();
		em.merge(employee);
		et.commit();
	}
	
	public void updateName(int id, String Name) {
		Employees employee = em.find(Employees.class, id);
		employee.setName(Name);
		et.begin();
		em.merge(employee);
		et.commit();
	}
	
	public void deleteById(int id) {
		Employees employee = em.find(Employees.class, id);
		et.begin();
		em.remove(employee);
		et.commit();	
	}
	
	public void saveEmployee(int id, String name,String email, long phone) {
		Employees e = new Employees(id,name,email,phone);
		et.begin();
		em.persist(e);
		et.commit();
	}
	public void ListOfAllEmployees() {
		Query query = em.createQuery("select s from Student s");
		List<Employees>employees = query.getResultList();
		for(Employees e:employees) {
			System.out.println("Id = "+e.getId()+", Name = "+e.getName()+", Email = "+e.getEmail()+", Phone = "+e.getPhone());
		}
	}
}