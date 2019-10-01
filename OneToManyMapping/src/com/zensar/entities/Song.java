package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Chaithrodaya B S
 * @Creation Date 27-09-19 4.40 PM
 * @Modification Date 27-09-19 4.40 PM
 * @Version 1.0 
 * @copyright Zensar Technologies Limited, All Rights Reserved
 */

@Entity

public class Song 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int songId;
	private String songName;
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	public Song() {
		// TODO Auto-generated constructor stub
	}
	
	public Song(int songId, String songName) {
		super();
		this.songId = songId;
		this.songName = songName;
	}

	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
	
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + "]";
	}

	public Song(String songName) {
		super();
		this.songName = songName;
	}
	
	
	
	
}
