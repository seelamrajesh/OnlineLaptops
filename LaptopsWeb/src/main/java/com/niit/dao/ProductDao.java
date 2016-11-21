package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.niit.model.Product;

@Repository
public class ProductDao {
	@Autowired
	SessionFactory sessionFactory;
	public void ProdSave(Product prod)
	{
		System.out.println("in Product Dao1");
		Session session= sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		session.save(prod);
		session.getTransaction().commit();
		session.close();
		System.out.println("in adProduct Dao2");
	}
	public String listProd()
	{
		System.out.println("in adProduct listproduct1");
		Session se= sessionFactory.openSession();
		se.beginTransaction();
		List li=se.createQuery("from Product").list();
		Gson gson = new Gson();
		
		String jsonprodlist=gson.toJson(li);
		se.getTransaction().commit();
		se.close();
		System.out.println("in adProduct list product2");
		return jsonprodlist ;
	}
	public void deleteProd(String pid)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		Product prod=(Product)se.get(Product.class,pid);
		se.delete(prod);
		se.getTransaction().commit();
		se.close();
	}
	public void updateProd(Product uprd)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		 String pid=uprd.getPid();
		Product adobj=(Product)se.get(Product.class,pid);
		adobj.setPdes(uprd.getPdes());
		adobj.setPname(uprd.getPname());
		adobj.setPprice(uprd.getPprice());
		adobj.setCatId(uprd.getCatId());
		adobj.setPstock(uprd.getPstock());
		adobj.setSupId(uprd.getSupId());
		se.update(adobj);
		 se.getTransaction().commit();
	
		 se.close();
	}
	public Product DispRecord(String pid)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		Product adpd=(Product)se.get(Product.class,pid);
		return adpd;
	}
}
