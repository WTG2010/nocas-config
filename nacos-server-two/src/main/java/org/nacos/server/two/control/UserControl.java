package org.nacos.server.two.control;

import org.nacos.server.two.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserControl {
	
	@Autowired
	private UserServer userServer;
	
	@PostMapping("reduce")
	private String reduce(String id,int money) {
		userServer.reduceMoney(id, money);
		return "success";
	}

}
