package com.lpu;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PersonServices {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	public void findById(int id) {
		Person person = em.find(Person.class, id);
		System.out.println(person.getId());
		System.out.println(person.getName());
		Adhaar a = person.getAdhar();
		System.out.println(a.getId());
		System.out.println(a.getLocation());
	}
	public void updateName(int id, String Name) {
		Person person = em.find(Person.class, id);
		person.setName(Name);
		et.begin();
		em.merge(person);
		et.commit();
	}
	public void updateLocation(int id, String Location) {
		Person person = em.find(Person.class, id);
		Adhaar a = person.getAdhar();
		a.setLocation(Location);
		et.begin();
		em.merge(person);
		em.merge(a);
		et.commit();
	}
	public void deleteById(int id) {
		Person person = em.find(Person.class, id);
		deleteByIdAdhaar(person.getAdhar().getId());
		et.begin();
		em.remove(person);
		et.commit();	
	}
	public void deleteByIdAdhaar(int id) {
		Adhaar a = em.find(Adhaar.class, id);
		et.begin();
		em.remove(a);
		et.commit();	
	}
	public void savePerson(int id, String name, int aid,String location) {
		Adhaar a = new Adhaar(aid,location);
		Person p = new Person(id,name,a);
		et.begin();
		em.persist(p);
		em.persist(a);
		et.commit();
	}
	/*public void ListOfAllStudents() {
		Query query = em.createQuery("select s from Student s");
		List<Student>students = query.getResultList();
		for(Student s:students) {
			System.out.println("Id = "+s.getId()+", Name = "+s.getName()+", Phone = "+s.getPhone());
		}
	}*/
}