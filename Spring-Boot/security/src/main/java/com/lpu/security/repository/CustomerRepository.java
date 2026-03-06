package com.lpu.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpu.security.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	Customer findByName(String name);
}
