package org.nacos.server.one.dao;

import org.nacos.server.one.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, String> {

}
