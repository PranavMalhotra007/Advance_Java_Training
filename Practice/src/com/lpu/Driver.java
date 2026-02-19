package com.lpu;

public class Driver {

}
class Employee{
	private int employee_id;
	private String name;
	private String role;
	private double salary;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getSalary() {
		return salary;
	}
	public void updateSalary(Employee e,double newSalary) throws UnauthorizedAccessException {
		if(this.role.equals("HR")) {
			e.salary = newSalary;
		}
		else {
			throw new UnauthorizedAccessException("Only HR can access");
		}
	}
	public Employee(int employee_id, String name, String role, double salary) {
		this.employee_id = employee_id;
		this.name = name;
		this.role = role;
		this.salary = salary;
	}
	public Employee() {
		
	}
	
}
class UnauthorizedAccessException extends Exception{
	public UnauthorizedAccessException(String message) {
        super(message);
    }
}
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}
