package com.example.demo.entity;

import java.time.LocalDateTime;

public class Post {
	private int postId;
	private String music_name;
	private String artist_name;
	private PostComment postComment;
	private int genre;
	private String caption;
	private LocalDateTime created;
	
	
//	コンストラクタ(引数なし)
	public Post() {
		
	}
	

//	getter/setter
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
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
	
	public PostComment getPostComment() {
		return postComment;
	}


	public void setPostComment(PostComment postComment) {
		this.postComment = postComment;
	}


	public int getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	

	

}
