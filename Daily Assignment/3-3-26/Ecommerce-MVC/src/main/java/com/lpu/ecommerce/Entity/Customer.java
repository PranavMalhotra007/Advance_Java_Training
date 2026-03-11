package com.lpu.ecommerce.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	private int customer_ID;
	private String name;
	private String email;
	private String address;
	private String password;
	@OneToMany(mappedBy = "customer", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	List<Orders>orderList;
	public int getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Orders> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}
	public Customer() {
		super();
	}
	public Customer(int customer_ID, String name, String email, String address, String password) {
		super();
		this.customer_ID = customer_ID;
		this.name = name;
		this.email = email;
		this.address = address;
		this.password = password;
	}
	
	
}
