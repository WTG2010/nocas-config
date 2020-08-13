package org.nacos.server.three.server.impl;

import org.nacos.server.three.bean.Order;
import org.nacos.server.three.dao.OrderDao;
import org.nacos.server.three.server.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServerImpl implements OrderServer{
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public void creatOrder(String userid, String productid, Integer price) {
		Order order = new Order();
		order.setOrderPrice(price);
		order.setProductId(productid);
		order.setUserId(userid);
		orderDao.save(order);
	}
	
	

}
