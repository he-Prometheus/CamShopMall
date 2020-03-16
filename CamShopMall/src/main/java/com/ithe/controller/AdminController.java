package com.ithe.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ithe.Utils.MD5Utils;
import com.ithe.entity.Admin;
import com.ithe.entity.Goods;
import com.ithe.entity.Imgs;
import com.ithe.entity.User;
import com.ithe.service.AdminService;
import com.ithe.service.GoodsService;
import com.ithe.service.ImgsService;
import com.ithe.service.UserService;

@Controller
public class AdminController {
	
	
	@Autowired
	public AdminService adminService;
	
	@Autowired
	public GoodsService goodsService;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public ImgsService imgsService;
	
	//登录管理员界面
	@RequestMapping("/admInfo")
	public String getAdmin(Model model,HttpServletRequest req) {
		Admin adm = (Admin) req.getSession().getAttribute("exitAdm");
		if(adm!=null&&!"".equals(adm.getAdmName())) {
			//转发查询商品列表
			return "forward:/adm/goodsList";
		}else {
			return "adminLogin";
		}
	}
	
	@RequestMapping("/admLogin")
	public String loginAdmin(Admin admin,Model model,HttpServletRequest req) {
		Admin adm = adminService.findAdminByName(admin.getAdmName());
		String passWorld ="";
		if(admin.getAdmPassword()!=null) {
			passWorld = MD5Utils.md5(admin.getAdmPassword());
		}
		
		if(passWorld.equals(adm.getAdmPassword())) {
			//转发查询商品列表
			req.getSession().setAttribute("exitAdm", adm);
			return "forward:/adm/goodsList";
		}else {
			model.addAttribute("msg", "登录用户名不存在或密码错误");
			return "adminLogin";
		}
	}
	
	//管理员界面查询商品列表和员工列表
	@RequestMapping("/adm/{Info}")
	public String listInfo(@PathVariable("Info") String info,Model model){
		int page = 0,size=12;
		if(info!=null &&"goodsList".equals(info)) {
			Page<Goods> findByPage  = goodsService.findByPage(page, size);
			model.addAttribute("page", findByPage);
			model.addAttribute("msg", "goods");
			System.out.println("msg=goods");
		}else if(info!=null &&"userList".equals(info)) {
			Page<User> findByPage  = userService.findByPage(page, size);
			model.addAttribute("page", findByPage);
			model.addAttribute("msg", "user");
			System.out.println("msg=user");
		}		
		return "Info/admin";
	}

    //管理员界面翻页方法
    @RequestMapping("/list")
    public String pageInfo(@RequestParam("Info") String info, 
    		@RequestParam(value = "pageNum", defaultValue = "0")  int page,Model model) {
    	
    	int size = 12;
    	if(info!=null &&"goods".equals(info)) {
			Page<Goods> findByPage  = goodsService.findByPage(page, size);
			model.addAttribute("page", findByPage);
			model.addAttribute("msg", "goods");
			System.out.println("msg=goods");
		}else if(info!=null &&"user".equals(info)) {
			Page<User> findByPage  = userService.findByPage(page, size);
			model.addAttribute("page", findByPage);
			model.addAttribute("msg", "user");
			System.out.println("msg=user");
		}		
    	return "Info/admin";
    }

    //templates文件夹中的html只能通过控制器才能到达
    @RequestMapping("/addGoods")
	public String addGoods(Model model) {
    	return "/Info/goods/goodsAdd";
    }

	//商品添加
	@RequestMapping("/add")
	public String addGoods(Goods goods, Model model,
			@RequestParam("uploadFile") MultipartFile file,HttpServletRequest req) throws IOException {
	    if (file.isEmpty()) {
	   	model.addAttribute("fileMsg","上传失败");
	        return "/Info/goods/goodsAdd";
	    }
	    String fileName = file.getOriginalFilename();
	    
	    File directory = new File("src/main/resources"); 
        String courseFile = directory.getCanonicalPath();
	    File dest = new File(courseFile +"/static/img/"+ fileName);
	    
        //保存图片
        Imgs img = new Imgs();
        img.setImgUrl(fileName);
        img.setGoods(goods);
        imgsService.save(img);
        
        Set<Imgs> simg = new HashSet<Imgs>();
        goods.setImgs(simg);
        
        if(req.getSession().getAttribute("exitAdm")!=null) {
        	Admin adm=adminService.findAdminByName(((Admin) req.getSession().getAttribute("exitAdm")).getAdmName());
        	goods.setAdm(adm);
        }
        
        Date currentDate = new Date(System.currentTimeMillis());
        goods.setGoodsModifiedTime(currentDate);
        //文件保存成功再保存数据到数据库
        try {
			file.transferTo(dest);
			goodsService.add(goods);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return "forward:/admInfo";
	}
	

    @RequestMapping("/deleteGoods")
    public void deleteGoods(@RequestParam("id") Integer id) {
    	goodsService.delete(id);
    }
}
