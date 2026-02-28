package com.lpu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	public void saveEmployee(Employee e) {
		employeeDao.saveEmployee(e);
	}
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}
	public void updateEmployee(int id, String name, String phone , String email) {
		employeeDao.updateEmployee(id, name, phone, email);
	}
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployee();
	}
	public Employee findEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findEmployee(id);
	}
}
