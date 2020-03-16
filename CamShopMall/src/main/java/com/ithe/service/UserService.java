package com.ithe.service;

import org.springframework.data.domain.Page;

import com.ithe.entity.User;

public interface UserService {
	
	public Page<User> findByPage(int page,int size);
	
	public User checkName(String username);
	
	public User findByName(String name);
	
	public User findById(Integer userId);

	public void delete(Integer userId);
	
    public void save(User user);
	
	public void update(User user);


}
