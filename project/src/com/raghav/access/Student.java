package com.raghav.access;

public class Student {
	private int userId;
	private String username;
	private String phone;
	private String password;
	private String table;
	
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public int getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private String email;

	
	
	public Student(int userId, String username, String email, String password, String phone) {
		super();
		this.userId = userId;
		this.username = username;
		this.phone = phone;
		this.password = password;
		this.email = email;
	}

	public Student(int userId, String username, String email, String phone) {
	
		this.userId = userId;
		this.username = username;
		this.phone = phone;
		this.email = email;
	}	

	public Student(int userId, String username, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
	}
	

	public Student(String username, String phone, String password) {
		super();
		this.username = username;
		this.phone = phone;
		this.password = password;
	}

	
	public Student(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public String toString() {
		return "Student [userId=" + userId + ", username=" + username + ", phone=" + phone + ", email=" + email + "]";
	}

	
}
