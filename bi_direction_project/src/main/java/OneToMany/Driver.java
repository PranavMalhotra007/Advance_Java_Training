package OneToMany;

import java.util.List;

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
		Bank b = new Bank(101,"SBI","UP");
		Account a1 = new Account(1,"Raju",100);
		Account a2 = new Account(2,"Ramu",50);
		List<Account>accountList = List.of(a1,a2);
		b.setAccountList(accountList);
		a1.setBank(b);
		a2.setBank(b);
		et.begin();
		em.persist(b);
		em.persist(a1);
		em.persist(a2);
		et.commit();
	}
}
