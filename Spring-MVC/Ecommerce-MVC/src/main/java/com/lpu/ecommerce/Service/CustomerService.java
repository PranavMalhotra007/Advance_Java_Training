package com.lpu.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.ecommerce.Dao.CustomerDao;
import com.lpu.ecommerce.Entity.Customer;
import com.lpu.ecommerce.Entity.Orders;


@Component
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
		public void saveCustomer(Customer c) {
			customerDao.saveCustomer(c);
		}
		public Customer findCustomer(int id) {
			return customerDao.findCustomer(id);
		}
		public void addOrder(Orders o, int id) {
			customerDao.addOrder(o, id);
		}
		public void deleteCustomer(int id) {
			customerDao.deleteCustomer(id);
		}
		public Customer loginCustomer(int id, String password) {
			return customerDao.loginCustomer(id, password);
		}
}