package com.lpu;

import javax.persistence.Entity;

import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class College {
	@Id
	private int id;
	private String name;
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
	public College() {
		super();
	}
	public College(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
