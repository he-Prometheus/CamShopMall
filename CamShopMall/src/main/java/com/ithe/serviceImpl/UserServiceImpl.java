package com.ithe.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ithe.dao.UserDao;
import com.ithe.entity.User;
import com.ithe.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDao userDao;

	@Override
	public Page<User> findByPage(int page, int size) {
		Pageable pageable= PageRequest.of(page,size);
		return userDao.findAll(pageable);
	}

	@Override
	public User findByName(String name) {
		
		return userDao.findByUserName(name);
	}

	@Override
	public User checkName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}
	
}
