package com.hospitalmanagment.entity;

public class User {
	private String fname;
	private String email;
	private String password;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
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
	@Override
	public String toString() {
		return "User [fname=" + fname + ", email=" + email + ", password=" + password + "]";
	}
	public User(String fname, String email, String password) {
		super();
		this.fname = fname;
		this.email = email;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
