package com.lpu.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.ecommerce.Dao.OrdersDao;
import com.lpu.ecommerce.Entity.Orders;
import com.lpu.ecommerce.Entity.Products;


@Component
public class OrdersService{ 
	@Autowired
	private OrdersDao ordersDao;
	public void saveOrder(Orders o) {
		ordersDao.saveOrder(o);
	}
	public Orders findOrder(int id) {
		return ordersDao.findOrder(id);
	}
	public void addProduct(Products p, int id) {
		ordersDao.addProduct(p, id);
	}
	public void deleteOrder(int id) {
		ordersDao.deleteOrder(id);
	}
}