package OneToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Bank {
	@Id
	private int id;
	private String name;
	private String location;
	@OneToMany
	private List<Account>accountList ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	public Bank() {
	}
	public Bank(int id, String name, String location, List<Account> accountList) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.accountList = accountList;
	}
	
}
