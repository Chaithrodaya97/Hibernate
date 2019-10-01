package com.zensar.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;


/**
 * @author Chaithrodaya B S
 * @Creation Date 27-09-19 4.30 PM
 * @Modification Date 27-09-19 4.30 PM
 *
 */
public class MovieDeleteDemo {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure();
		SessionFactory sess = c.buildSessionFactory();
		Session s = sess.openSession();
		Transaction t = s.beginTransaction();
		Movie m = s.get(Movie.class, 1);
		System.out.println(m.getTitle());
		System.out.println(m.getReleaseDate());
		List<Song> songs= m.getSongs();
		for(Song so : songs)
		{
			System.out.println(so);
		}
		if(m!=null)
		{
			s.delete(m);
			
		}
		else
		{
			System.out.println("Sorry!!!! Movie not Found");
		}
			
		t.commit();
		s.close();
		System.exit(0);
	}

}
