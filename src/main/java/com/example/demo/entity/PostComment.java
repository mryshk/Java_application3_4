package com.example.demo.entity;

import java.time.LocalDate;

public class PostComment {
	
	private int userId;
	private int postId;
	private String comment;
	private LocalDate created;
	
	
	
	
	
//	コンストラクタ
	public PostComment() {
		
	}

//	getter/setter
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		postId = postId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDate getCreated() {
		return created;
	}
	public void setCreated(LocalDate created) {
		this.created = created;
	}
	

}
