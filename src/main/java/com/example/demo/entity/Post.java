package com.example.demo.entity;

import java.time.LocalDate;

public class Post {
	private int id;
	private int user_id;
	private String music_name;
	private String artist_name;
	private int genreId;
	private GenreType genreType;
	private String caption;
	private LocalDate created;
	
	
	
//	getter/setter
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return user_id;
	}


	public void setUserId(int user_id) {
		this.user_id = user_id;
	}


	public String getMusic_name() {
		return music_name;
	}


	public void setMusic_name(String music_name) {
		this.music_name = music_name;
	}


	public String getArtist_name() {
		return artist_name;
	}


	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}


	public int getGenreId() {
		return genreId;
	}


	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}


	public GenreType getGenreType() {
		return genreType;
	}


	public void setGenreType(GenreType genreType) {
		this.genreType = genreType;
	}


	public String getCaption() {
		return caption;
	}


	public void setCaption(String caption) {
		this.caption = caption;
	}


	public LocalDate getCreated() {
		return created;
	}


	public void setCreated(LocalDate created) {
		this.created = created;
	}



	
	
//	コンストラクタ(引数なし)
	public Post() {
		
	}
	





	

	

}
