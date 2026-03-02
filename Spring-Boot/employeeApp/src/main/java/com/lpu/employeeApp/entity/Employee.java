package com.lpu.employeeApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name cannot be blank")
	@Pattern(regexp = "^[A-Za-z ]+$",message = "Not a vaild Employee Name")
	private String name;
	@Pattern(regexp = "\\d{10}",message = "Phone must be 10 digits")
	private String phone;
	@Email(message = "Enter valid email")
	private String email;
	@Min(value = 18)
	@Max(value = 75)
	private int age;
	@Min(value = 10)
	private double salary;
	@Pattern(regexp = "^[A-Za-z ]+$",message = "Not a vaild Department Name")
	private String department;
	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private Company company;
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Employee( String name, String phone,String email, int age, double salary,String department) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.salary = salary;
		this.department = department;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", salary=" + salary
				+ ", department=" + department + "]";
	}
	
}
