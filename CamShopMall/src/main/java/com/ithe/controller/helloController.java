package com.ithe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class helloController {

	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("msg", "success");
		
		return "top";
	}
}
