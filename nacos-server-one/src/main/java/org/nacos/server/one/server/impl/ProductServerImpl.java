package org.nacos.server.one.server.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.nacos.server.one.server.ProductServer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServerImpl implements ProductServer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void buyOne(String id) {
		Map<String, String> msg = new HashMap<>();
		msg.put("productId", id);
		msg.put("buyTime", new Date().toString());
		rabbitTemplate.convertAndSend(msg);
	}

}
