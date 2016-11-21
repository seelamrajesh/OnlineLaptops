package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

@Controller

public class CategoryController {
	@Autowired
	CategoryDao catDao;
	
	@RequestMapping(value="/CategoryPage",method = RequestMethod.GET)
	public ModelAndView showCategory()
	{
		System.out.println("line 1 in get Adding category");
		ModelAndView mv= new ModelAndView("CategoryPage","Category",new Category());
		System.out.println(" line 2 in get Adding category");
		String catjsonlist=catDao.listCat();
		
		mv.addObject("data",catjsonlist);
		mv.addObject("check",true);
		
		return mv;
		
	}
	@RequestMapping(value="/addcat",method=RequestMethod.POST)
	public ModelAndView catSave(Category cat)
	{
		catDao.catSave(cat);
		@SuppressWarnings("unused")
		String cat1=catDao.listCat();
		System.out.println("line 1 in get Adding category");
		ModelAndView mv = new ModelAndView("CategoryPage","Category",new Category());
		System.out.println("line 1 in get Adding category");
		mv.addObject("data1",cat1);
		String catjsonlist= catDao.listCat();
		
		mv.addObject("data",catjsonlist);
		mv.addObject("check",true);
		
		return mv;
		
	}
	@RequestMapping(value="/deletecat",method = RequestMethod.GET)
	public ModelAndView deletecat(@RequestParam("cid")String cid)
	{
		catDao.deletecat(cid);
		
		String catjosn=catDao.listCat();
		 ModelAndView m= new ModelAndView("CategoryPage","Category",new Category());
		m.addObject("data2",catjosn);
		String catjsonlist=catDao.listCat();
		
		m.addObject("data",catjsonlist);
		
		
		return m;
		
	}
	@RequestMapping(value="/updatecat",method=RequestMethod.GET)
	public ModelAndView updatecat(@RequestParam("cid")String cid)
	{
		Category cat2= catDao.DisRecord(cid);
		ModelAndView m = new ModelAndView("CategoryPage","Category",cat2);
		String catjsonlist=catDao.listCat();
		m.addObject("data",catjsonlist);
		
		return m;
		
	}
	@RequestMapping(value="/updatecat",method=RequestMethod.POST)
	public ModelAndView updatecat(Category cat3)
	{ 
		catDao.updatecat(cat3);
		String catjsonlist=catDao.listCat();
		ModelAndView m= new ModelAndView("CategoryPage","Category",new Category());
		m.addObject("check",false);
		m.addObject("data3",catjsonlist);
		String catjsonlist1=catDao.listCat();
		m.addObject("data",catjsonlist1);
		return m;
		
	}
}
