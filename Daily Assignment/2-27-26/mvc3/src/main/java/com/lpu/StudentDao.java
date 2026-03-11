package com.lpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class StudentDao {
	@Autowired
	private EntityManagerFactory emf;
	public void saveStudent(Student s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(s);
		et.commit();
		em.close();
	}
	public Student findStudent(int id) {
		EntityManager em = emf.createEntityManager();
		Student s = em.find(Student.class, id);
		em.close();
		return s;
	}
}
