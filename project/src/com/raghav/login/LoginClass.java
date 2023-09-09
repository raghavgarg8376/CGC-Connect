package com.raghav.login;

import java.io.Serializable;

public class LoginClass implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String table;
	private String email;
	private String userID;
	private String phone;
	private String stream;
	private String Martial_Status;
	private String Gender;
	

	public LoginClass(String username, String password, String email, String phone, 
			String gender) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		Gender = gender;
	}

	public LoginClass(String username, String password, String email, String userID, String phone, String stream) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.userID = userID;
		this.phone = phone;
		this.stream = stream;
	}

	public LoginClass() {
		// TODO Auto-generated constructor stub
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getMartial_Status() {
		return Martial_Status;
	}

	public void setMartial_Status(String martial_Status) {
		Martial_Status = martial_Status;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
