package com.example.demo.entity;

import java.time.LocalDateTime;

public class User {
	private String name;
	private String email;
	private String password;
	private LocalDateTime created;
	
	
	
	
	
//	コンストラクタ
	public User() {
		
	}
	
//	getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	
	
	
	

}
