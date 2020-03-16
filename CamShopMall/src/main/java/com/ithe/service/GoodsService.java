package com.ithe.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.ithe.dao.GoodsDao;
import com.ithe.entity.Goods;

public interface GoodsService {
	
	public Page<Goods> findByPage(int page,int size);

	public List<Goods> findGoodsByLikeName(String name);
	
	public List<Goods> findGoodsByUserId(Integer id);
	
	public Goods findByid(Integer id);
	
	public void saveGoods(Goods goods);

	public void add(Goods goods);
	
	public void delete(Integer id);
	
	public void update(Goods goods);
}
