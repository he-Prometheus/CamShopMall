package com.ithe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ithe.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
	

}
