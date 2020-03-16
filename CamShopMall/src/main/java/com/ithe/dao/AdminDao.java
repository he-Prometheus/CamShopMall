package com.ithe.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ithe.entity.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer>{
	
	public Admin findByAdmName(String name);

}
