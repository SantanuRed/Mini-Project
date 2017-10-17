package com.cg.oirs.dto;

public class User {
	private String user_id;
	private String password;
	private String role;
	
	
	public User() {
		super();
	}


	public User(String user_id, String password, String role) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.role = role;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	
}
