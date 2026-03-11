package com.lpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
	@Value("101")
	private int id;
	@Value("XYZ")
	private String name;
	@Autowired
	private Adhar adhar;
	@Autowired
	//@Qualifier(value= "bike")
	private Vehicle v;
	@Autowired
	@Qualifier(value="mango")
	private Fruit fruit;
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
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
	public Adhar getAdhar() {
		return adhar;
	}
	public void setAdhar(Adhar adhar) {
		this.adhar = adhar;
	}
	public Vehicle getV() {
		return v;
	}
	public void setV(Vehicle v) {
		this.v = v;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", adhar=" + adhar + ", v=" + v + ", fruit=" + fruit + "]";
	}
	
}
