package com.ithe.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ithe.dao.ImgsDao;
import com.ithe.entity.Imgs;
import com.ithe.service.ImgsService;

@Transactional
@Service
public class ImgsServiceImpl implements ImgsService {

	@Autowired
	public ImgsDao imgsDao;
	
	@Override
	public void save(Imgs img) {
		// TODO Auto-generated method stub
		imgsDao.save(img);

	}

	@Override
	public void delete(Imgs img) {
		// TODO Auto-generated method stub
		imgsDao.delete(img);
	}

}
