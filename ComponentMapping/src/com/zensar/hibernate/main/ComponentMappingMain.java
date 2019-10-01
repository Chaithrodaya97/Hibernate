package com.zensar.hibernate.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;

import com.zensar.entities.Customer;
import com.zensar.entities.Name;

public class ComponentMappingMain {

	public static void main(String[] args) 
	{
		Configuration c = new Configuration().configure();
		SessionFactory session = c.buildSessionFactory();
		Session s = session.openSession();
		Transaction t = s.beginTransaction();
		Name name = new Name();
		name.setFirstName("Charan");
		name.setMiddleName("Sule");
		name.setLastName("Chetty");
		
		Customer cust = new Customer(6, name, "Female", 22,"Mangalore");
		cust.setDob(LocalDate.of(1997, 01, 06)); 
		try
		{
			File photo = new File("./resources/download.jpg");
			FileInputStream fin = new FileInputStream(photo); // read file input stream
		
			Blob customerPhoto = BlobProxy.generateProxy(fin, photo.length());
			cust.setProfilePhoto(customerPhoto);
			File text = new File("./resources/customerInfo.txt");
			FileReader fin2 = new FileReader(text); // read file input stream
			Clob cl = ClobProxy.generateProxy(fin2, text.length());
			cust.setDescription(cl);
			s.save(cust);
			t.commit();
			session.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
