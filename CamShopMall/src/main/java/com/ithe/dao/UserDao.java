package com.ithe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ithe.entity.Admin;
import com.ithe.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	public User findByUserName(String name);
	
}
