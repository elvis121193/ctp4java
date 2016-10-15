package org.mohe.ctp.dao.impl;

import java.util.List;

import org.mohe.ctp.dao.OrderDao;
import org.mohe.ctp.entity.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public class OrderDaoImpl extends BaseDao implements OrderDao {

	public void save(Order order) {
		mongoTemplate.save(order);
	}

	public Order getOrderByOrderRef(String orderRef) {
		List<Order> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("orderRef").is(orderRef)), Order.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

}
