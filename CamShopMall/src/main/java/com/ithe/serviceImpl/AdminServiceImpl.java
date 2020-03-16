package com.ithe.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ithe.dao.AdminDao;
import com.ithe.entity.Admin;
import com.ithe.service.AdminService;


@Transactional
@Service
public class AdminServiceImpl implements AdminService{
	
	
	
	@Autowired
	public AdminDao adminDao;

	@Override
	public Admin findAdminByName(String name) {
		
		return adminDao.findByAdmName(name);
	}
	
}
