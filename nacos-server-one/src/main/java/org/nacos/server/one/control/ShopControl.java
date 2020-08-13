package org.nacos.server.one.control;

import org.nacos.server.one.server.ProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopControl {
	
	@Autowired
	private ProductServer productServer;  
	
	@GetMapping("/product/{userId}/{productId}")
	private void BuyOne(@PathVariable("userId") String userId,@PathVariable("productId") String productId) {
		productServer.buyOne(userId,productId);
	}

}
