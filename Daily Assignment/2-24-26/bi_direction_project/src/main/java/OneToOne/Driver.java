package OneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {
	public static void main(String[]args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		System.out.println(emf);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		/*Person person = new Person(10,"Ramu");
		Adhar adhar = new Adhar(101,"India");
		person.setAdhar(adhar);
		adhar.setPerson(person);
		et.begin();
		em.persist(person);
		em.persist(adhar);
		et.commit();*/
		Person p = em.find(Person.class, 10);
		Adhar a = p.getAdhar();
		//System.out.println(a.getLocation());
	}
}
