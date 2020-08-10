package org.nacos.server.two.dao;

import org.nacos.server.two.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String>{

}
