package com.pro.uas.dto;

public class Users {
	private String login_id;
	private String password;
	private String role;
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
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
		return "Users [login_id=" + login_id  + ", role=" + role + "]";
	}
	
	
}
