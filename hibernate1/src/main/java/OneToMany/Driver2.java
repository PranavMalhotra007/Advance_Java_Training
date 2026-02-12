package OneToMany;


import java.util.ArrayList;
import java.util.List;

import com.lpu.CarServices;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class Driver2 {   
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	public static void main(String[] args) {
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		Cinema c = new Cinema(10,"Inox","Indore");
		CinemaHall ch = new CinemaHall(1,250);
		List<CinemaHall>list = new ArrayList<>();
		list.add(ch);
		c.setCinemaHalls(list);
		et.begin();
		em.persist(c);
		em.persist(ch);
		et.commit();
		//CarServices services = new CarServices();
		//services.findById(10);
		//services.saveCar(20, "BMW", 108, "500");
		//services.saveCar(40, "Audi", 102, "600");
		//services.saveCar(30, "BMW", 103, "800");
		//services.findCarByBrand("BMW");
		
	}
}