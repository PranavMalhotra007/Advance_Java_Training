package com.lpu.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lpu.security.entity.Customer;
import com.lpu.security.repository.CustomerRepository;
@Service
public class CustomerUserDetailsService implements UserDetailsService {
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findByName(username);
		return new CustomerUserDetails(customer);
	}
	
}
