package com.lpu;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int id;
	private String name;
	@OneToOne
	private Adhaar adhar;
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
	public Adhaar getAdhar() {
		return adhar;
	}
	public void setAdhar(Adhaar adhar) {
		this.adhar = adhar;
	}
	public Person(int id, String name, Adhaar adhar) {
		this.id = id;
		this.name = name;
		this.adhar = adhar;
	}
	public Person() {
		
	}
}
