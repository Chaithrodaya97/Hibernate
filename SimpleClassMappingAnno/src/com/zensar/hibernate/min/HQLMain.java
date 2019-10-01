package com.zensar.hibernate.min;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.CreateKeySecondPass;

import com.zensar.entities.Product;

//Hibernate Query Language(Object Oriented Query Language)
public class HQLMain 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure();
		
		//SingleTon and heavyweight SessionFactory
		SessionFactory f = c.buildSessionFactory();
		Session s = f.openSession(); // Represents Database Connection & Lightweight
		Transaction t = s.beginTransaction();
		
		//JPA Query
		//Query q = s.createQuery("from Product");
		//Query q = s.createQuery("from Product pr where pr.price>5000 and pr.price<35000 and pr.name='TABLET'");
		//Query q = s.createQuery("from Product pr where pr.price between 8000 and 30000");
		//Query q = s.createQuery("from Product pr where pr.brand like 'S%'");
		
		/*
		Query q = s.createQuery("from Product pr where pr.name ='TABLET'");
		List<Product> products = q.getResultList();
		for(Product p:products)
		{
			System.out.println(p);
		}
		*/
		
		/*
		   //New Query
		
		Query q = s.createQuery("select pr.name,pr.price from Product pr");
		Query q = s.createQuery("select pr.Product(name,price)");
	
		
		List<Object[]> objects = q.getResultList();
		for(Object[] obj:objects)
		{
			for(int i=0;i<obj.length;i++)
			{
				System.out.println(obj[i]);
			}
		}
	   */
		
		//MaxPrice
		Query q = s.createQuery("select max(pr.price) from Product pr");
		Float maxPrice = (Float) q.getSingleResult();
		System.out.println(maxPrice);
		
		//MinPrice
		Query q1 = s.createQuery("select min(pr.price) from Product pr");
		Float minPrice = (Float) q1.getSingleResult();
		System.out.println(minPrice);
		
		//Sum
		Query q2 = s.createQuery("select sum(pr.price) from Product pr");
		Double sum = (Double) q2.getSingleResult();
		System.out.println(sum);
		
		//Count
		Query q3 = s.createQuery("select count(pr.price) from Product pr");
		long count = (long) q3.getSingleResult();
		System.out.println(count);
		
		//Average
		Query q4 = s.createQuery("select avg(pr.price) from Product pr");
		double average = (double) q4.getSingleResult();
		System.out.println(average);
		
		
		Criteria cr = s.createCriteria(Product.class);
		List<Product> products  = cr.list();
		for(Product pr:products)
		{
			System.out.println(pr);
		}
		
	    t.commit();
		s.close();
	}

}
