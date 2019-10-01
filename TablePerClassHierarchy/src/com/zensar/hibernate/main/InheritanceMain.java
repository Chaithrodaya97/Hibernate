package com.zensar.hibernate.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Employee;
import com.zensar.entities.WageEmp;

public class InheritanceMain
{

	public static void main(String[] args) 
	{
		Configuration c = new Configuration().configure();
		SessionFactory sess = c.buildSessionFactory();
		Session s = sess.openSession();
		Transaction t = s.beginTransaction();
		Employee e = new Employee();
		e.setName("Charan");
		e.setJoinDate(LocalDate.of(2010, 8, 7));
		e.setSalary(15000);
		s.save(e);
	
		WageEmp we = new WageEmp();
		we.setName("Chaithrodaya");
		we.setJoinDate(LocalDate.of(2019, 8, 26));
		we.setSalary(20000);
		we.setHours(9);
		we.setRate(500.0f);
		s.save(we);
		t.commit();
		s.close();

	}

}
