package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Product;

@Controller
public class ProductController {
	@Autowired
	CategoryDao catDao;
	@Autowired
	SupplierDao supDao;
	@Autowired
	ProductDao prodDao;
	
	@RequestMapping(value="/ProductPage",method=RequestMethod.GET)
	public ModelAndView showProduct()
	{
		ModelAndView mv = new ModelAndView("ProductPage","Product",new Product());
	    String catjsonlist=catDao.listCat();
	    mv.addObject("data",catjsonlist);
	    
	    String supjsonlist=supDao.listSup();
	    mv.addObject("data2",supjsonlist);
	    String prod=prodDao.listProd();
	    mv.addObject("data3",prod);
	    mv.addObject("check", true);
	    return mv;    
	}
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public ModelAndView addAdminProduct(Product aprod)
	{
		System.out.println("in addAdminProduct post1");
	    prodDao.ProdSave(aprod); 
		System.out.println("in addAdminProduct post2");
		String prd=prodDao.listProd();
		ModelAndView mv = new ModelAndView("ProductPage","Product",new Product());
		mv.addObject("data3",prd);
		String catjsonlist=catDao.listCat();
		
		mv.addObject("data",catjsonlist);
		System.out.println("in addAdminProduct post3");
		String supjsonlist=supDao.listSup();
		System.out.println("in addAdminProduct post4");
		mv.addObject("data2",supjsonlist);
		mv.addObject("check",true);
		System.out.println("in addAdminProduct post5");
		
		System.out.println("in addAdminProduct post6"+prd);
		
		System.out.println("in addAdminProduct post7");
		String path="C:\\Users\\RAJESH\\OnlineLaptops\\src\\main\\webapp\\WEB-INF\\resources\\images";
		path=path+String.valueOf(aprod.getPid())+".jpg";
		System.out.println("in addProduct post8");
		File f=new File(path);
		System.out.println("in addProduct post9");
		System.out.println("in addProduct post9"+prd);
		MultipartFile filedet=aprod.getPimage();
		System.out.println("in addProduct post10"+filedet);
		if(!filedet.isEmpty())
		{
			System.out.println("in addProduct post10");
			try
			{
				System.out.println("before getbytes");
				System.out.println(filedet);
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		 return mv;
		
	}
	@RequestMapping(value="/deleteprod",method = RequestMethod.GET)
	public ModelAndView deleteProd(@RequestParam("pid")String pid)
	{
		prodDao.deleteProd(pid);
		String prjson=prodDao.listProd();
		ModelAndView m =new ModelAndView("ProductPage","Product",new Product());
		m.addObject("check",true);
		m.addObject("data3",prjson);
	
		String catjsonlist=catDao.listCat();
		
		m.addObject("data", catjsonlist);
		String supjsonlist=supDao.listSup();
		m.addObject("data2", supjsonlist);
		return m;
		
	}
	@RequestMapping(value="/Updateprod",method=RequestMethod.GET)
	public ModelAndView updateProd(@RequestParam("pid")String pid)
	{
		Product ad =prodDao.DispRecord(pid);
		ModelAndView m = new ModelAndView("ProductPage","Product",ad);
		

		System.out.println("pro id"+ad.getPid());
		m.addObject("check",false);
		String catjsonlist=catDao.listCat();
		
		m.addObject("data",catjsonlist);
		String supjsonlist=supDao.listSup();
		m.addObject("data2",supjsonlist);
		String pdjsonlist=prodDao.listProd();
		m.addObject("data3",pdjsonlist);
		System.out.println(supjsonlist);
		return m;
	}
	@RequestMapping(value="/Updateprod",method=RequestMethod.POST)
	public ModelAndView updateProd(Product pd)
	{
		prodDao.updateProd(pd);
		String apdjsonlist=prodDao.listProd();
		ModelAndView m = new ModelAndView("ProductPage","Product",new Product());
		m.addObject("check",true);
		m.addObject("data3",apdjsonlist);
		String catjsonlist=catDao.listCat();
		
		
		
		m.addObject("data",catjsonlist);
		String supjsonlist=supDao.listSup();
		m.addObject("data2",supjsonlist);
	
		
		
		return m;
		
	}
	
	
	
	
}