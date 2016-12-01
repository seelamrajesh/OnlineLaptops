package com.niit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;


@Controller

public class SuppilerController {
	@Autowired
	SupplierDao supDao;
	
	@RequestMapping(value="/SupplierPage",method = RequestMethod.GET)
	public ModelAndView showSupplier()
	{
		System.out.println("line 1 in get Adding Supplier");
		ModelAndView mv= new ModelAndView("SupplierPage","Supplier",new Supplier());
		System.out.println(" line 2 in get Adding Supplier");
		String supjsonlist=supDao.listSup();
		
		mv.addObject("data",supjsonlist);
		mv.addObject("check",true);
		
		return mv;
		
	}
	@RequestMapping(value="/addsup",method=RequestMethod.POST)
	public ModelAndView supSave(Supplier sup)
	{
		supDao.supSave(sup);
		@SuppressWarnings("unused")
		String sup1=supDao.listSup();
		System.out.println("line 1 in get Adding Supplier");
		ModelAndView mv = new ModelAndView("SupplierPage","Supplier",new Supplier());
		System.out.println("line 1 in get Adding Supplier");
		mv.addObject("data1",sup1);
		String supjsonlist= supDao.listSup();
		
		mv.addObject("data",supjsonlist);
		mv.addObject("check",true);
		
		return mv;
		
	}
	@RequestMapping(value="/deletesup",method = RequestMethod.GET)
	public ModelAndView deletesup(@RequestParam("sid")String sid)
	{
		supDao.deletesup(sid);
		
		String supjosn=supDao.listSup();
		 ModelAndView m= new ModelAndView("SupplierPage","Supplier",new Supplier());
		m.addObject("data2",supjosn);
		String supjsonlist=supDao.listSup();
		
		m.addObject("data",supjsonlist);
		
		
		return m;
		
	}
	@RequestMapping(value="/updatesup",method=RequestMethod.GET)
	public ModelAndView updatesup(@RequestParam("sid")String sid)
	{
		Supplier sup2= supDao.DisRecord(sid);
		ModelAndView m = new ModelAndView("SupplierPage","Supplier",sup2);
		String supjsonlist=supDao.listSup();
		m.addObject("data",supjsonlist);
		
		return m;
		
	}
	@RequestMapping(value="/updatesup",method=RequestMethod.POST)
	public ModelAndView updatesup(Supplier sup3)
	{ 
	supDao.updatesup(sup3);
		String supjsonlist=supDao.listSup();
		ModelAndView m= new ModelAndView("SupplierPage","Supplier",new Supplier());
		m.addObject("check",false);
		m.addObject("data3",supjsonlist);
		String supjsonlist1=supDao.listSup();
		m.addObject("data",supjsonlist1);
		return m;
		
	}
}