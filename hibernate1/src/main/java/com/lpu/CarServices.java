package com.lpu;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CarServices {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	public void findById(int id) {
		Car car = em.find(Car.class, id);
		System.out.println(car.getId());
		System.out.println(car.getBrand());
		Engine engine = car.getEngine();
		System.out.println(engine.getId());
		System.out.println(engine.getCc());
	}
	public void updateBrand(int id, String brand) {
		Car car = em.find(Car.class, id);
		car.setBrand(brand);
		et.begin();
		em.merge(car);
		et.commit();
	}
	public void updateCc(int id, String cc) {
		Car car = em.find(Car.class, id);
		Engine engine = car.getEngine();
		engine.setCc(cc);
		et.begin();
		em.merge(car);
		em.merge(engine);
		et.commit();
	}
	public void deleteById(int id) {
		Car car = em.find(Car.class, id);
		deleteByIdEngine(car.getEngine().getId());
		et.begin();
		em.remove(car);
		et.commit();	
	}
	public void deleteByIdEngine(int id) {
		Engine engine = em.find(Engine.class, id);
		et.begin();
		em.remove(engine);
		et.commit();	
	}
	public void saveCar(int id, String brand, int eid, String cc) {
		Engine engine = new Engine(eid,cc);
		Car car = new Car(id,brand,engine);
		et.begin();
		em.persist(car);
		em.persist(engine);
		et.commit();
	}
	public void ListOfAllCar() {
		Query query = em.createQuery("select c from Car c");
		List<Car>cars = query.getResultList();
		for(Car c:cars) {
			System.out.println("Id = "+c.getId()
	    	+", Brand = "+c.getBrand()
	    	+", Engine Id = "+c.getEngine().getId()
	    	+", CC = "+c.getEngine().getCc());
		}
	}
	public void findCarByBrand(String brand) {
	    Query query = em.createQuery("SELECT c FROM Car c WHERE c.brand = :b");
	    query.setParameter("b", brand);

	    List<Car> cars = query.getResultList();

	    for (Car c : cars) {
	    	System.out.println("Id = "+c.getId()
	    	+", Brand = "+c.getBrand()
	    	+", Engine Id = "+c.getEngine().getId()
	    	+", CC = "+c.getEngine().getCc());
	    }
	}

}