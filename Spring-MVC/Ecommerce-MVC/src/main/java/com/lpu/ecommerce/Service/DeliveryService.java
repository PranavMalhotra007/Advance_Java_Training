package com.lpu.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.ecommerce.Dao.DeliveryDao;
import com.lpu.ecommerce.Entity.Delivery;
import com.lpu.ecommerce.Entity.Orders;
@Component
public class DeliveryService {
	@Autowired
	private DeliveryDao deliveryDao;
		public void saveDelivery(Delivery d) {
			deliveryDao.saveDelivery(d);
		}
		public Delivery findDelivery(int id) {
			return deliveryDao.findDelivery(id);
		}
		public void addOrder(Orders o, int id) {
			deliveryDao.addOrder(o, id);
		}
		public void deleteDelivery(int id) {
			deliveryDao.deleteDelivery(id);
		}
}