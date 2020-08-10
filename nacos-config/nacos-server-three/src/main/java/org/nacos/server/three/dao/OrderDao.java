package org.nacos.server.three.dao;

import org.nacos.server.three.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, String>{

}
