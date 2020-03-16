package com.ithe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ithe.Utils.MD5Utils;
import com.ithe.Utils.PageUtils;
import com.ithe.entity.Admin;
import com.ithe.entity.Goods;
import com.ithe.entity.User;
import com.ithe.service.GoodsService;
import com.ithe.service.IMailService;
import com.ithe.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public GoodsService goodsService;
	
    @Autowired
    private IMailService mailService;
	
	@RequestMapping("/register")
	public String userRegister(User user,Model model) {
		if(user==null||user.getUserName()==null) {
			return "register";
		}
		return null;
	}
	
	
	//用户登录界面
	@RequestMapping("/login")
	public String toLogin(User user,Model model,HttpServletRequest req) {
		return "login";
	}
	
	//用户登录
	@RequestMapping("userLogin")
	public String userLogin(User user,Model model,HttpServletRequest req) {
		//查数据库中的user
		User use = userService.findByName(user.getUserName());
		String passWorld ="";
		if(user.getUserPassword()!=null) {
			passWorld = MD5Utils.md5(user.getUserPassword());
		}
		
		if(passWorld.equals(use.getUserPassword())) {
			//转发查询商品列表
			req.getSession().setAttribute("exitUser", use);
			return "redirect:/index";
		}else {
			model.addAttribute("usermsg", "登录用户名不存在或密码错误");
			return "login";
		}
		
	}
	//用户退出
	@RequestMapping("/userExit")
	public String exitUser(Model model,HttpServletRequest req) {
		req.getSession().removeAttribute("exitUser");
		System.out.println("req.getSession().removeAttribute(\"exitUser\");");
		
		return "forward:index";
	}
	
	//用户个人中心
	@RequestMapping("/userInfo")
	public String userInfo(Model model,HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("exitUser");
	    if(user==null||user.getUserName()==null||"".equals(user.getUserName())) {
		  return "redirect:/index"; 
		}
		User userInfo = userService.findByName(user.getUserName());
		req.getSession().setAttribute("userInfo",userInfo);
		
		List<Goods> list = goodsService.findGoodsByUserId(userInfo.getUserId());
        Pageable pageable = PageRequest.of(0,list.size());
		Page<Goods> pageList = PageUtils.createPageFromList(list, pageable);
		model.addAttribute("page", pageList); 
		return "Info/userInfo";
	}
	
	
	@RequestMapping("/userRegist")
	public String userRegist(User user,Model model) {
		
		mailService.sendSimpleMail(user.getUserEmail(),"主题：欢迎来到人文商城","内容：邮件发送成功");
		
		String pwd = user.getUserPassword();
		user.setUserPassword(MD5Utils.md5(pwd));
		userService.save(user);
		
		return "forward:/index";
	}
}
