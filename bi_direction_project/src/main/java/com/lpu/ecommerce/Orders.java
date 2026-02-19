package com.lpu.ecommerce;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {
	@Id
	private int order_ID;
	private String date;
	@ManyToOne
	@JoinColumn
	private Delivery delivery;
	@ManyToOne
	@JoinColumn
	private Customer customer;
	@ManyToMany(mappedBy = "orderList")
	private List<Products>productList;
	public int getOrder_ID() {
		return order_ID;
	}
	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Products> getProductList() {
		return productList;
	}
	public void setProductList(List<Products> productList) {
		this.productList = productList;
	}
	public Orders() {
		super();
	}
	

}
