package ManyToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class Driver {   
	//static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	//static EntityManager em = emf.createEntityManager();
	//static EntityTransaction et = em.getTransaction();
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		 //EntityManager em = emf.createEntityManager();
		 //EntityTransaction et = em.getTransaction();
		
		//CompanyServices services = new CompanyServices();
		/*Company c = new Company();
		c.setId(10);
		c.setName("Capgemini");
		c.setLocation("Hyderabad");
		Employee e1 = new Employee();
		e1.setId(101);
		e1.setName("Raju");
		//e1.setSalary(40000);
		e1.setCompany(c);
		Employee e2 = new Employee();
		e2.setId(102);
		e2.setName("Arifus");
		//e2.setSalary(500000);
		e2.setCompany(c);
		//services.saveCompany(c);
		services.saveEmployee(e1);
		services.saveEmployee(e2);	*/
		//services.findByIdEmployee(101);
	}
}