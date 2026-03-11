package com.lpu.employeeApp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Company Name cannot be blank")
	@Pattern(regexp = "^[A-Za-z0-9 ]+$",message = "Not a vaild Company Name")
	private String name;
	@NotBlank(message = "Location cannot be blank")
	@Pattern(regexp = "^[A-Za-z0-9 ]+$",message = "Not a vaild Location Name")
	private String location;
	@OneToMany(mappedBy = "company" , cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Employee> employees;
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public int getId() {
		return id;
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
	public Company() {
		super();
	}
	public Company(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
}
