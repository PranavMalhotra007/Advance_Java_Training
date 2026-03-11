package ManyToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CompanyServices {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	public void saveCompany(Company company) {
		et.begin();
		em.persist(company);
		et.commit();
	}
	public void saveEmployee(Employee e) {
		et.begin();
		em.persist(e);
		et.commit();
	}
	public void findByIdEmployee(int id) {
		Employee e = em.find(Employee.class,id );
		System.out.println("Id = "+e.getId());
		System.out.println("Name = "+e.getName());
		Company c = e.getCompany();
		System.out.println("Company Id = "+c.getId());
		System.out.println("Company Name = "+c.getName());
		System.out.println("Company Location = "+c.getLocation());
	}
}
