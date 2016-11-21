package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.niit.model.Category;

@Repository
public class CategoryDao {
	@Autowired
	SessionFactory sessionFactory;
   public void catSave(Category cat)
   {
	   Session session=sessionFactory.openSession();
	   System.out.println("insert method is called");
	   session.beginTransaction();
	   session.save(cat);
	   session.getTransaction().commit();
	   session.close();
   }
  public String listCat()
  {
	  System.out.println("in catgory list");
	  Session se= sessionFactory.openSession();
	  se.beginTransaction();
	  List li=se.createQuery("from Category").list();
	     Gson gson=new Gson();
	     
	  String jsoncatlist=gson.toJson(li);
	  se.getTransaction().commit();
	  se.close();
	  return jsoncatlist;
  }
  public void deletecat(String cid)
  {
	  Session se=sessionFactory.openSession();
	  se.beginTransaction();
	  Category cat=(Category) se.get(Category.class,cid);
	  se.delete(cat);
	  se.getTransaction().commit();
	  se.close();
  }
  public void updatecat(Category cat)
  {
	  Session se=sessionFactory.openSession();
	  se.beginTransaction();
	  String cid=cat.getCid();
	  Category catobj=(Category) se.get(Category.class,cid);
	  catobj.setCdescription(cat.getCdescription());
	  catobj.setCname(cat.getCname());
	  
	  se.update(catobj);
	  se.getTransaction().commit();
	  se.close();
  }
  public Category DisRecord(String cid)
  {
	  Session se= sessionFactory.openSession();
	  se.beginTransaction();
	  Category cats=(Category) se.get(Category.class, cid);
	 
	return cats;
	  
  }

}
