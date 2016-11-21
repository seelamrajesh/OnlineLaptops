package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.niit.model.Supplier;


@Repository
public class SupplierDao {
	@Autowired
	SessionFactory sessionFactory;
   public void supSave(Supplier sup)
   {
	   Session session=sessionFactory.openSession();
	   System.out.println("insert method is called");
	   session.beginTransaction();
	   session.save(sup);
	   session.getTransaction().commit();
	   session.close();
   }
  public String listSup()
  {
	  System.out.println("in Supplier list");
	  Session se= sessionFactory.openSession();
	  se.beginTransaction();
	  List li=se.createQuery("from Supplier").list();
	     Gson gson=new Gson();
	     
	  String jsoncatlist=gson.toJson(li);
	  se.getTransaction().commit();
	  se.close();
	  return jsoncatlist;
  }
  public void deletesup(String sid)
  {
	  Session se=sessionFactory.openSession();
	  se.beginTransaction();
	  Supplier sup=(Supplier) se.get(Supplier.class,sid);
	  se.delete(sup);
	  se.getTransaction().commit();
	  se.close();
  }
  public void updatesup(Supplier sup)
  {
	  Session se=sessionFactory.openSession();
	  se.beginTransaction();
	  String sid=sup.getSid();
	  Supplier supobj=(Supplier) se.get(Supplier.class,sid);
	  supobj.setSaddr(sup.getSaddr());
	  supobj.setSname(sup.getSname());
	  
	  se.update(supobj);
	  se.getTransaction().commit();
	  se.close();
  }
  public Supplier DisRecord(String sid)
  {
	  Session se= sessionFactory.openSession();
	  se.beginTransaction();
	  Supplier sups=(Supplier) se.get(Supplier.class, sid);
	 
	return sups;
	  
  }

}
