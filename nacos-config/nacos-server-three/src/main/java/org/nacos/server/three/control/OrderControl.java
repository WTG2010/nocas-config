package org.nacos.server.three.control;

import org.nacos.server.three.server.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderControl {

	@Autowired
	private OrderServer orderServer;

	@PostMapping("creat")
	public String creatOrder(String userid, String productid, Integer price) {
		orderServer.creatOrder(userid, productid, price);
		return "success";
	}
	
}
