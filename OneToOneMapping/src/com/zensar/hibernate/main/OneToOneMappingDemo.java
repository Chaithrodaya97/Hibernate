package com.zensar.hibernate.main;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Country;
import com.zensar.entities.Flag;

public class OneToOneMappingDemo {

	public static void main(String[] args) 
	{
		Configuration c = new Configuration().configure();
		SessionFactory sess = c.buildSessionFactory();
		Session s = sess.openSession();
		Transaction t = s.beginTransaction();
		Country co = new Country();
	    co.setName("India");
	    co.setLanguage("All Language");
	    co.setPopulation(1300000000l);
		
		Flag f = new Flag();
		f.setFlagName("Tricolor");
		f.setDescription("It is a tricolor Flag");
		co.setFlag(f);
		f.setCountry(co);
		s.save(f);
		s.save(co);
		
		t.commit();
		s.close();
		System.exit(0);
		

	}

}
