package OneToMany;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {
	public static void main(String[]args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Bank b = new Bank(103,"HDFC","Delhi");
		Account a1 = new Account(7,"XYZ",100);
		Account a2 = new Account(9,"ABC",500);
		List<Account>accountList = List.of(a1,a2);
		BankServices services = new BankServices();
		//services.savebank(b);
		//services.giveAccountsToBank(103, accountList);
		//System.out.println(services.findBankById(101));
		//services.giveAccountsToBank(103, accountList);
		//services.findAllAccountsInBank(103);
		//services.findAllAccountsInBank("SBI");
		services.findBankById(103);
		
	}
}
