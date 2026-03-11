package com.lpu.employeeApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.employeeApp.entity.Company;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.exception.CompanyNotFoundException;
import com.lpu.employeeApp.repository.CompanyRepository;
@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private EmployeeService employeeService;
	public Company saveCompany(Company c) {
		return companyRepository.save(c);
	}
	public Company saveCompanyAndMapWithEmp(Company c) {
		c.getEmployees().forEach((emp)->emp.setCompany(c));
		return companyRepository.save(c);
	}
	public List<Company> allCompany(){
		List<Company>company = companyRepository.findAll();
		if(!company.isEmpty()) {
			return company;
		}
		throw new CompanyNotFoundException("Database is Empty");
	}
	public String deleteCompany(int id) {
		findComapnyById(id);
		companyRepository.deleteById(id);
		return "Company destoryed";
	}
	public Company findComapnyById(int id) {
		return companyRepository.findById(id).orElseThrow(
				()-> new CompanyNotFoundException("Company with id = "+id+" does not exists"));
	}
	public String deleteCompany(Company c) {
		findComapnyById(c.getId());
		companyRepository.delete(c);
		return "Company destoryed";
	}
	public List<Company> getCompanyByName(String name){
		List<Company>company = companyRepository.getCompanyByName(name);
		if(!company.isEmpty()) {
			return company;
		}
		throw new CompanyNotFoundException("Company with name = "+name+" does not exists");
	}
	public Company saveEmployeesToExistingCompany(int id, List<Employee> newEmployees) {
		Company c = findComapnyById(id);
		c.getEmployees().addAll(newEmployees);
		return saveCompanyAndMapWithEmp(c);
	}
	public Company giveEmployeeToExistingCompany(int cid, int eid) {
		Employee e = employeeService.findEmployeeById(eid);
		Company c = findComapnyById(cid);
		c.getEmployees().add(e);
		return saveCompanyAndMapWithEmp(c);	
	}
}
