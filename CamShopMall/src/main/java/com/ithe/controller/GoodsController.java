package com.ithe.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.LifecycleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ithe.Utils.PageUtils;
import com.ithe.dao.GoodsDao;
import com.ithe.entity.Admin;
import com.ithe.entity.Goods;
import com.ithe.entity.Imgs;
import com.ithe.entity.User;
import com.ithe.service.AdminService;
import com.ithe.service.GoodsService;
import com.ithe.service.ImgsService;
import com.ithe.service.UserService;

@Controller
public class GoodsController {
	
	@Autowired
	public GoodsService goodsService;
	
	@Autowired
	public ImgsService imgsService;
	
	
	@Autowired
	public AdminService adminService;
	
	@Autowired
	public UserService userService;
	
	//点击上下页时
	@RequestMapping("/showGoods")
	public String findByGoods(@RequestParam(value = "pageNum", defaultValue = "0")  int pageNum,
			 @RequestParam(value = "pageSize", defaultValue = "12") int pageSize,Model model) {
		Page<Goods> findByPage = goodsService.findByPage(pageNum,pageSize); 
		List<Goods> list = findByPage.getContent();
		model.addAttribute("page", findByPage);
		model.addAttribute("pagesize", pageSize);
		model.addAttribute("listGoods", list); 
		model.addAttribute("totalCount",findByPage.getTotalElements()); 
		model.addAttribute("totalPage",findByPage.getTotalPages()); 
		model.addAttribute("pageCode", pageNum);
		return "main";
	}

	
//	第一次打开页面时
	@RequestMapping("/index")
	public String showGoods(Model model) {
		
		int page = 0; //page:当前页的索引。注意索引都是从0开始的。
		int size = 12;// size:每页显示3条数据
		
		Page<Goods> findByPage = goodsService.findByPage(page,size); 
		List<Goods> list =findByPage.getContent();
		model.addAttribute("page", findByPage);
		model.addAttribute("pagesize", 12);
		model.addAttribute("listGoods", list); 
		model.addAttribute("totalCount",findByPage.getTotalElements()); 
		model.addAttribute("totalPage",findByPage.getTotalPages()); 
		model.addAttribute("pageCode", page);
		return "main";
	}
	
	//模糊查询
	@RequestMapping("/findGoodsLike")
	public String findByLikeName(@RequestParam("goodsName")String name,Model model) {
		
		List<Goods> list = goodsService.findGoodsByLikeName(name);
		
		Pageable pageable = PageRequest.of(0,list.size());
		Page<Goods> pageList = PageUtils.createPageFromList(list, pageable);
		model.addAttribute("page", pageList); 
		
		return "main";
	}

	@RequestMapping("/goodsDetails")
	public String goodsDetails(@RequestParam("goodsId") Integer id ,Model model,HttpServletRequest req) {
		
		Goods goodsDetails = goodsService.findByid(id);
		System.err.println(goodsDetails);
		model.addAttribute("goodsDetails",goodsDetails);
		return "Info/goods";
		
	}
}
