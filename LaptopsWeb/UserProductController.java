package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.UserProductDao;

@Controller
public class UserProductController {
	
	@Autowired
	CategoryDao catdao;
	@Autowired
	ProductDao prdao;
	@Autowired
	UserProductDao updao;
	
	@RequestMapping("/userproduct")
	public String userproduct(Model m)
	{
		String prod = prdao.listProd();
		m.addAttribute("data3",prod);
		return "userproduct";
	}
	/*@RequestMapping("/Desktop")
	public String userdesk(Model m)
	{
		String prod = prdao.listCatWise("Desktop");
		m.addAttribute("data3",prod);
		return "userproduct";
		
	}
	@RequestMapping("/Desktop")
	public String userlaptop(Model m)
	{
		String prod=prdao.listCatWise("Laptop");
		m.addAttribute("data3",prod);
		
		return "userproduct";
		
			
	}*/
	

}
