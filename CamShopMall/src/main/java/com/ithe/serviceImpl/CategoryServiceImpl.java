package com.ithe.serviceImpl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ithe.dao.CategoryDao;
import com.ithe.entity.Category;
import com.ithe.service.CategoryService;



@Transactional
@Service
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired
	public CategoryDao categoryDao;

	@Override
	public Category findById(int id) {
		
		return categoryDao.getOne(id);
	}
	
	
	
	
	
}
