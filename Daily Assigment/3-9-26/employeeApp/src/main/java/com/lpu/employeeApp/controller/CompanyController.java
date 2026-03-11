package com.lpu.employeeApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.employeeApp.entity.Company;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.service.CompanyService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	@PostMapping("/save")
	public ResponseEntity<Company> saveCompany(@Valid @RequestBody Company c) {
		Company company = companyService.saveCompany(c);
		return ResponseEntity.status(HttpStatus.CREATED).body(company);
	}
	@PostMapping
	public ResponseEntity<Company> saveCompanyAndMapWithEmp(@Valid @RequestBody Company c) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(companyService.saveCompanyAndMapWithEmp(c));
	}
	@PostMapping("/{id}")
	public ResponseEntity<Company> giveEmployeesToExistingCompany(@PathVariable int id, @RequestBody List<Employee> newEmployees) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(companyService.saveEmployeesToExistingCompany(id, newEmployees));
	}
	@GetMapping
	public ResponseEntity<List<Company>> allCompany(){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(companyService.allCompany());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.GONE)
				.body(companyService.deleteCompany(id));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Company> findComapnyById(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(companyService.findComapnyById(id));
	}
	@DeleteMapping
	public ResponseEntity<String> deleteCompany(@Valid @RequestBody Company c) {
		return ResponseEntity.status(HttpStatus.GONE)
				.body(companyService.deleteCompany(c));
	}
	@DeleteMapping("/name/{name}")
	public ResponseEntity<List<Company>> getCompanyByName(@PathVariable String name){
		return ResponseEntity.status(HttpStatus.GONE)
				.body(companyService.getCompanyByName(name));
	}
	@PostMapping("/{cid}/{eid}")
	public ResponseEntity<Company> saveExistingEmpToExistingComp(@PathVariable int cid, @PathVariable int eid) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(companyService.giveEmployeeToExistingCompany(cid, eid));
	}
	@PostMapping("/result/{a}/{b}")
	public ResponseEntity<String> resultPrint(@PathVariable int a, @PathVariable int b) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("result = "+ a/b);
	}
}
