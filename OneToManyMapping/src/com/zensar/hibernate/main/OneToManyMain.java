package com.zensar.hibernate.main;

import java.time.LocalDate;
import java.util.ArrayList;
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
public class OneToManyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure();
		SessionFactory sess = c.buildSessionFactory();
		Session s = sess.openSession();
		Transaction t = s.beginTransaction();
		Movie mov = new Movie();
		mov.setTitle("Chennai Express");
		mov.setReleaseDate(LocalDate.of(2019, 9, 15));
		
		Song so1 = new Song();
		so1.setSongName("Lungi Dance");
		
		Song so2 = new Song();
		so2.setSongName("Lungi Dance");
		
		Song so3 = new Song();
		so3.setSongName("Lungi Dance");
		
		so1.setMovie(mov);
		so2.setMovie(mov);
		so3.setMovie(mov);
		
		List<Song> songs = new ArrayList<Song>();
		songs.add(so1);
		songs.add(so2);
		songs.add(so3);
		
		
		mov.setSongs(songs);
		
		s.save(mov);
		s.save(so1);
		s.save(so2);
		s.save(so3);
		
		t.commit();
		s.close();
		System.exit(0);
	}

}
