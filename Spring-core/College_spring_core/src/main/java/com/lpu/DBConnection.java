package com.lpu;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class DBConnection {
	@Autowired
	EntityManagerFactory emf;
	public DBConnection() {
		System.out.println("bean object created");
	}
	@PostConstruct
	public void init() {
		emf = Persistence.createEntityManagerFactory("dev");
		System.out.println("initialization phase 2");
	}
	public void fetchData() {
		EntityManager em = emf.createEntityManager();
		College c = em.find(College.class, 1);
		System.out.println(c.getName());
	}
	@PreDestroy
	public void closeEMF() {
		emf.close();
		System.out.println("DB conncetion is closed");
	}
}
