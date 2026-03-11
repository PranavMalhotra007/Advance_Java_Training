package com.lpu.employeeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lpu.employeeApp.entity.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	@Query("select c from Company c where c.name = :name")
	List<Company> getCompanyByName(String name);
}
