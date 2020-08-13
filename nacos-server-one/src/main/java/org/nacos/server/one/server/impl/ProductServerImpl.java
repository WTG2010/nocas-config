package org.nacos.server.one.server.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.nacos.server.one.bean.Product;
import org.nacos.server.one.dao.ProductDao;
import org.nacos.server.one.server.ProductServer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServerImpl implements ProductServer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ProductDao productDao;

	@Override
	public void buyOne(String userId, String productId) {
		
		Map<String, String> msg = new HashMap<>();
		msg.put("productId", productId);
		msg.put("buyTime", new Date().toString());
		rabbitTemplate.convertAndSend(msg);
		
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
		
		//本地扣库存(暂未考虑并发)
		Product dbProduct = productDao.findById(productId).get();
		int total = dbProduct.getTotal()-1;
		dbProduct.setTotal(total);
		productDao.save(dbProduct);
		//建订单
		param.add("userid", userId);
		param.add("productid", productId);
		param.add("price", dbProduct.getMoney());
		restTemplate.postForEntity("http://127.0.0.1:56012/order/creat", param, String.class);
		param.clear();
		System.out.println("清理param---"+param);
		//扣余额
		param.add("id", userId);
		param.add("money", dbProduct.getMoney());
		restTemplate.postForEntity("http://127.0.0.1:56011/user/reduce", param, String.class);
		param.clear();
		System.out.println("清理param---"+param);
		
	}

}
