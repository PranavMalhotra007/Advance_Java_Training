package OneToMany;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class BankServices implements BankCRUD{
	 private static EntityManagerFactory emf =Persistence.createEntityManagerFactory("dev");
	 private static EntityManager em = emf.createEntityManager();
	 private static EntityTransaction et = em.getTransaction();
	@Override
	public void savebank(Bank bank) {
		// TODO Auto-generated method stub
		et.begin();
		em.persist(bank);
		et.commit();
		
	}

	@Override
	public void updateBank(int id, Bank bank) {
		// TODO Auto-generated method stub
		Bank b = em.find(Bank.class, id);
		b.setName(bank.getName());
		b.setLocation(bank.getLocation());
		et.begin();
		em.merge(b);
		et.commit();
	}

	@Override
	public Bank findBankById(int id) {
		// TODO Auto-generated method stub
		Bank bank = em.find(Bank.class, id);
		return bank;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Bank findBankByName(String name) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select b from Bank b Where b.name = :name");
		query.setParameter("name", name);
		List<Bank> list = query.getResultList();
	    return list.get(0);
	}

	@Override
	public void giveAccountToBank(int bankId, Account newAccount) {
		// TODO Auto-generated method stub
		et.begin();
		Bank bank = em.find(Bank.class, bankId);
		newAccount.setBank(bank);
		bank.getAccountList().add(newAccount);
		et.commit();	
	}

	@Override
	public void giveAccountsToBank(int bankId, List<Account> accounts) {
		// TODO Auto-generated method stub
		et.begin();
		Bank bank = em.find(Bank.class, bankId);
		for(Account a:accounts) {
			a.setBank(bank);
			bank.getAccountList().add(a);
		}
		et.commit();
		
	}
	@Override
	public void findAllAccountsInBank(int bankId) {
		// TODO Auto-generated method stub
		Bank bank = em.find(Bank.class, bankId);
		for(Account a:bank.getAccountList()) {
			System.out.println(a);
		}
	}

	@Override
	public void findAllAccountsInBank(String name) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select b from Bank b Where b.name = :name");
		query.setParameter("name", name);
		List<Bank> list = query.getResultList();
	    Bank bank = list.get(0);
	    for(Account a:bank.getAccountList()) {
	    	System.out.println(a);
	    }
	}
	
}
