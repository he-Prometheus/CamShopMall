package com.ithe.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.id.insert.IdentifierGeneratingInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ithe.dao.GoodsDao;
import com.ithe.entity.Goods;
import com.ithe.service.GoodsService;


@Transactional
@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	public GoodsDao goodsDao;

	public Page<Goods> findByPage(int page,int size) {
		
		Pageable pageable= PageRequest.of(page,size);
		Page<Goods> pageGoods = goodsDao.findAll(pageable);
		return pageGoods;
	}

	@Override
	public List<Goods> findGoodsByLikeName(String name) {
		return goodsDao.findByGoodsNameLike(name);
	}

	@Override
	public void saveGoods(Goods goods) {
		goodsDao.saveAndFlush(goods);
	}

	@Override
	public void add(Goods goods) {
		goodsDao.save(goods);
	}

	@Override
	public void delete(Integer id) {
		goodsDao.deleteById(id);
		
	}

	@Override
	public void update(Goods goods) {
		goodsDao.saveAndFlush(goods);
		
	}

	@Override
	public List<Goods> findGoodsByUserId(Integer id) {
		return goodsDao.findGoodsByuserId(id);
	}

	@Override
	public Goods findByid(Integer id) {
		return goodsDao.findById(id).get();
	}
}
