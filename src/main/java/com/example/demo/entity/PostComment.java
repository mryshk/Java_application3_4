package com.example.demo.entity;

import java.time.LocalDateTime;

public class PostComment {
	
	private int userId;
	private int postId;
	private String comment;
	private LocalDateTime created;
	
	
	
	
	
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
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	

}
