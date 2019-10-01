package com.zensar.hibernate.min;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

public class DbOperations {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure();
		
		//SingleTon and heavyweight SessionFactory
		SessionFactory f = c.buildSessionFactory();
		Session s = f.openSession(); // Represents Database Connection & Lightweight
		Transaction t = s.beginTransaction();
		
		/*insert new record
		Product p = new Product(1003,"PC","Dell",30000);*/
		
		Product p = s.get(Product.class, 1004);
		
		//get record according to primary key
	
		if(p != (null))
		{
			System.out.println(p);
		}
		
		else
		{
			System.out.println("Product not found");
		}
		
		//Product p = s.load(Product.class, 1003);

		
		p = s.get(Product.class, 1002);
		if(p!=(null))
		{
			p.setPrice(2000);
			s.update(p);
		}
		else
		{
			System.out.println("Product not found");
		}
		
		p = s.get(Product.class, 1002);
		if(p!=(null))
		{
			p.setPrice((p.getPrice()+2000));
			s.update(p);
		}
		else
		{
			System.out.println("Product not found");
		}
		
		p = s.get(Product.class, 1002);
		if(p!=(null))
		{
			s.delete(p);
			System.out.println("Product deleted");
		}
		else
		{
			System.out.println("Product not found");
		}
		
		t.commit();
		s.close();

	}

}
