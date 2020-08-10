package org.nacos.server.two.server.impl;

import org.nacos.server.two.bean.User;
import org.nacos.server.two.dao.UserDao;
import org.nacos.server.two.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServerImpl implements UserServer{
	
	@Autowired
	private UserDao userDao;

	@Override
	public synchronized void reduceMoney(String userId, int much) {
		User dbUser = userDao.findById(userId).get();
		int money = dbUser.getMoney() - much;
		dbUser.setMoney(money);
		userDao.save(dbUser);
	}

}
