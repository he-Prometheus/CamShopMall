package com.ithe.Test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.catalina.LifecycleListener;
import org.hibernate.collection.internal.PersistentSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import com.ithe.dao.AdminDao;
import com.ithe.dao.CategoryDao;
import com.ithe.dao.GoodsDao;
import com.ithe.dao.OrderDao;
import com.ithe.dao.UserDao;
import com.ithe.entity.Admin;
import com.ithe.entity.Category;
import com.ithe.entity.Goods;
import com.ithe.entity.Order;
import com.ithe.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestMall {
	
	@Autowired
	public AdminDao adminDao;
	
	@Autowired
	public GoodsDao goodsDao;
	
	
	@Test
	public void testAdmin() {
		Optional<Admin> adm = adminDao.findById(1);
		
		
		System.out.println(adm.get().getAdmName()+"--------------");
		
		Set set = (Set<Goods>) adm.get().getAdmGoodsSet();
		
		Iterator iterator = set.iterator();
		
		if(iterator.hasNext()) {
			Goods goo = (Goods) iterator.next();
			System.out.println(goo.getGoodsName()+"---------------"+goo.getGoodsDesc());
		}
		 
	}


    @Autowired
    public OrderDao orderDao;
    
    @Test
    public void testOrder() {
    	Optional<Order> order = orderDao.findById(1);
    	
    		System.out.println(order.get().getOrdeId()+"----");
    }
    
    
    @Autowired
    public UserDao userDao;
    
    @Test
    public void testUserDao() {
    	Optional<User> user =  userDao.findById(1);
    	
    	System.out.println(user.get().getUserName()+"============");
    }
    
    
    @Autowired
    public CategoryDao categoryDao;

	private String basePath;
    
    @Test
    public void testCategoryDao() {
    	Optional<Category> category =  categoryDao.findById(1);
    	
    	System.out.println(category.get().getProName()+"============");
    }
    
    
    
    @Test
    public void testGoods() {
    	Optional<Goods> findOne = goodsDao.findById(1);
    	
    	System.out.println(findOne.get().getGoodsName()+"============================");
    	
    	
    }
    
    
    @Test
    public void testFile() throws IOException {
        try {
			File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        File directory = new File("src/main/resources"); 
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);
    }

}
