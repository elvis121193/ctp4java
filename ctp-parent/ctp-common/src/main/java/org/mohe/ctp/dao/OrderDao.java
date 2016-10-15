package org.mohe.ctp.dao;

import org.mohe.ctp.entity.Order;

public interface OrderDao {
	
	public void save(Order order);
	
	public Order getOrderByOrderRef(String orderRef);
}
