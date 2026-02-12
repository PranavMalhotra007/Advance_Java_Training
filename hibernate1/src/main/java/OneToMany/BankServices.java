package OneToMany;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
//import jakarta.persistence.Query;

public class BankServices {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	public static void main(String[]args) {
		BankServices services = new BankServices();
		/*Account a1 = new Account(101,"Arifus",3000);
		Account a2 = new Account(102,"Natus",2000);
		List<Account>accountList = List.of(a1,a2);
		services.saveBank(1,"SBI","Local",accountList);*/
		services.findById(1);
	}
	public void saveBank(int id, String name, String location, List<Account> accountList) {
		Bank bank = new Bank(id,name,location,accountList);
		et.begin();
		em.persist(bank);
		for(Account a:bank.getAccountList()) {
			em.persist(a);
		}
		et.commit();
	}
	public void findById(int id) {
		Bank bank = em.find(Bank.class, id);
		System.out.println("Bank Id = "+bank.getId());
		System.out.println("Bank Name = "+bank.getName());
		System.out.println("Bank Locations = "+bank.getLocation());
		System.out.println("Account List:- ");
		for(Account account:bank.getAccountList()) {
			System.out.println("Account Id = "+account.getId());
			System.out.println("Name = "+account.getName());
			System.out.println("Balance = "+account.getBalance());
		}
	}
	/*public void updateBrand(int id, String brand) {
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
	}*/

}