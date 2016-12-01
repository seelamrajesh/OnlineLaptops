package com.niit.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.niit.dao.InsertDao;
import com.niit.model.Register;

@Controller
@RequestMapping(value = "/register")
public class RegController {
	 @Autowired
	   InsertDao indao;
	
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewRegistration() 
    {
     ModelAndView mv=new ModelAndView("register","command",new Register());
     return mv;
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("Register")Register reg,Map<String, Object> model) {
         
    	
        // implement your own registration logic here...
         
        // for testing purpose:
        System.out.println("username: " + reg.getName());
        System.out.println("password: " + reg.getPassword());
       // System.out.println("email: " + user.getEmail());
       
        
        indao.insertData(reg);
        
         
        return "result";
    }
}
