package com.lpu.employeeApp.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.employeeApp.dto.EmployeeDTO;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.exception.EmployeeNotFoundException;
import com.lpu.employeeApp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	public EmployeeDTO entityToDTO(Employee e) {
		EmployeeDTO emp = new EmployeeDTO();
		emp.setName(e.getName());
		emp.setId(e.getId());
		emp.setEmail(e.getEmail());
		emp.setPhone(e.getPhone());
		emp.setAge(e.getAge());
		return emp;
	}
	public Employee DTOToEntity(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		e.setAge(dto.getAge());
		e.setName(dto.getName());
		e.setEmail(dto.getEmail());
		e.setPhone(dto.getPhone());;
		return e;
	}
	public EmployeeDTO saveEmployee(EmployeeDTO dto) {
		Employee e = DTOToEntity(dto);
		employeeRepository.save(e);
		return entityToDTO(e);
	}
	public List<EmployeeDTO> allEmployees(){
		List<Employee>employee = employeeRepository.findAll();
		if(!employee.isEmpty()) {
			return employee.stream()
					.map(e->entityToDTO(e))
					.collect(Collectors.toList());
		}
		throw new EmployeeNotFoundException("Database is Empty");
	}
	public String deleteEmployee(int id) {
		findEmployeeById(id);
		employeeRepository.deleteById(id);
		return "employee deleted";
	}
	public Employee findEmployeeById(int id) {
		return employeeRepository.findById(id).orElseThrow(
				()-> new EmployeeNotFoundException("Employee with Id = "+id+ " does not exist"));
	}
	public List<Employee> getEmployeeByName(String name){
		List<Employee>employee = employeeRepository.getEmployeeByName(name);
		if(!employee.isEmpty()) {
			return employee;
		}
		throw new EmployeeNotFoundException("Employee with name = "+name+ " does not exist");
	}
	public List<Employee> getEmployeeByDepartment(String department){
		List<Employee>employee = employeeRepository.getEmployeeByDepartment(department);
		if(!employee.isEmpty()) {
			return employee;
		}
		throw new EmployeeNotFoundException("Employee with department name = "+department+ " does not exist");
	}
	public List<Employee> getEmployeeByPhone(String phone){
		List<Employee>employee = employeeRepository.getEmployeeByPhone(phone);
		if(!employee.isEmpty()) {
			return employee;
		}
		throw new EmployeeNotFoundException("Employee with phone = "+phone+ " does not exist");
	}
	public List<Employee> getEmployeeByEmail(String email){
		List<Employee>employee = employeeRepository.getEmployeeByEmail(email);
		if(!employee.isEmpty()) {
			return employee;
		}
		throw new EmployeeNotFoundException("Employee with email = "+email+ " does not exist");
	}
	public Employee updateEmployee(Employee e) {
		findEmployeeById(e.getId());
		return employeeRepository.save(e);
	}
	public List<Employee> maxSalaryEmployee(){
		List<Employee>employee = employeeRepository.getEmployeeWithMaxSalary();
		if(!employee.isEmpty()) {
			return employee;
		}
		throw new EmployeeNotFoundException("Database is Empty");
	}
	public List<Employee> minSalaryEmployee(){
		List<Employee>employee = employeeRepository.getEmployeeWithMinSalary();
		if(!employee.isEmpty()) {
			return employee;
		}
		throw new EmployeeNotFoundException("Database is Empty");
	}
	public List<Employee> rangeSalary(double min,double max){
		List<Employee>employee = employeeRepository.getEmployeesWithinRange(min, max);
		if(!employee.isEmpty()) {
			return employee;
		}
		throw new EmployeeNotFoundException("Employee with Salary above"+min+" and below "+max+ " exist in database");
	}
	public List<Employee> aboveSalary(double salary){
		List<Employee>employee = employeeRepository.getEmployeesWithSalaryAbove(salary);
		if(!employee.isEmpty()) {
			return employee;
		}
		throw new EmployeeNotFoundException("Employee with Salary above"+salary+ " exist in database");
	}
 }
