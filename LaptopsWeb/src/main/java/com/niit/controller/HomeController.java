package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
	public HomeController(){
		
		System.out.println("at controller");
		
	}

 	
	@RequestMapping("/home")
	public String home()
	{
	return "home";	
	}
	
	@RequestMapping("/about")
	public String forabout()
	{
	return "about";	
	}
	@RequestMapping("/contact")
	public String forcontact()
	{
	return "contact";	
	}
	@RequestMapping("/registe")
	public String forregister()
	{
	return "register";	
	}
	
}
