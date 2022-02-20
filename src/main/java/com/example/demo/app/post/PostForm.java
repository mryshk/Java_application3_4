package com.example.demo.app.post;

import java.time.LocalDateTime;

import com.example.demo.entity.PostComment;


public class PostForm {
	
	@NOT NULL
	private String music_name;
	
	private String artist_name;
	
	private PostComment postComment;
	
	private int genre;
	
	private String caption;
	
	private LocalDateTime created;

}
