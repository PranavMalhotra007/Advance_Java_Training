package com.lpu.ecommerce;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Delivery {
	@Id
	private int delivery_id;
	private String type;
	private String status;
	@OneToMany(mappedBy = "delivery")
	private List<Orders>orderList;
	public int getDelivery_id() {
		return delivery_id;
	}
	public String getType() {
		return type;
	}
	public String getStatus() {
		return status;
	}
	public List<Orders> getOrderList() {
		return orderList;
	}
	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}
	public Delivery() {
		super();
	}
	
}
