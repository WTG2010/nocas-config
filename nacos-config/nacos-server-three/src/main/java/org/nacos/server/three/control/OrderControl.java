package org.nacos.server.three.control;

import org.nacos.server.three.server.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name="order")
public class OrderControl {
	
	@Autowired
	private OrderServer orderServer;

	@PostMapping("creat")
	public void creatOrder(String userid, String productid, String price) {
		orderServer.creatOrder(userid, productid, price);
	}
	
}
