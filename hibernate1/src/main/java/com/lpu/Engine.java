package com.lpu;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
 class Engine {
	@Id
	private int id;
	private String cc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public Engine() {
		
	}
	public Engine(int id, String cc) {
		
		this.id = id;
		this.cc = cc;
	}
	
}
