package com.ithe.config;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class myWebConfig  implements WebMvcConfigurer{
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
		    WebMvcConfigurer.super.addViewControllers(registry);
	        registry.addViewController("/").setViewName("/login");
	        registry.addViewController("/login").setViewName("/login");
	        registry.addViewController("/register").setViewName("/register");
	        registry.addViewController("/addGoods").setViewName("/Info/goods/goodsAdd");
	        registry.addViewController("/main.html").setViewName("/main");
		}
}
