package com.lpu.ecommerce;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {
	@Id
private int product_id;
private String product_name;
@ManyToOne
@JoinColumn
private Categories category;
@ManyToMany
@JoinTable
private List<Orders>orderList;
public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public Categories getCategory() {
	return category;
}
public void setCategory(Categories category) {
	this.category = category;
}
public Products() {
	super();
}
}
