package com.lpu.employeeApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.service.EmployeeService;

import jakarta.validation.Valid;
@RequestMapping("/api/employees")
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee e) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(employeeService.saveEmployee(e));
	}
	@GetMapping
	public ResponseEntity<List<Employee>> findAllEmployee(){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(employeeService.allEmployees());
	}
	@GetMapping(params = "id")
	public ResponseEntity<Employee> findEmployeeById(@RequestParam int id) {
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(employeeService.findEmployeeById(id));
	}
	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(employeeService.updateEmployee(e));
	}
	@DeleteMapping
	public ResponseEntity<String> deleteEmployee(@RequestParam int id) {
		return ResponseEntity.status(HttpStatus.GONE)
				.body(employeeService.deleteEmployee(id));
	}
	@GetMapping(value = "/search" , params = "name" )
	public ResponseEntity<List<Employee>> searchByName(@RequestParam String name){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(employeeService.getEmployeeByName(name));
	}
	@GetMapping(value = "/search" , params = "department" )
	public ResponseEntity<List<Employee>> searchByDepartemnt(@RequestParam String department){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(employeeService.getEmployeeByDepartment(department));
	}
	@GetMapping(value = "/search" , params = "phone" )
	public ResponseEntity<List<Employee>> searchByPhone(@RequestParam String phone){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(employeeService.getEmployeeByPhone(phone));
	}
	@GetMapping(value = "/search" , params = "email" )
	public ResponseEntity<List<Employee>> searchByEmail(@RequestParam String email){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(employeeService.getEmployeeByEmail(email));
	}
	@GetMapping("/search/max")
	public ResponseEntity<List<Employee>> searchMax(){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(employeeService.maxSalaryEmployee());
	}
	@GetMapping("/search/min")
	public ResponseEntity<List<Employee>> searchMin(){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(employeeService.minSalaryEmployee());
	}
	@GetMapping(value = "/search" , params = "salary" )
	public ResponseEntity<List<Employee>> searchByEmail(@RequestParam double salary){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(employeeService.aboveSalary(salary));
	}
	@GetMapping(value = "/search" , params = {"min","max"})
	public ResponseEntity<List<Employee>> searchByEmail(@RequestParam double min, @RequestParam double max){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(employeeService.rangeSalary(min, max));
	}
}
