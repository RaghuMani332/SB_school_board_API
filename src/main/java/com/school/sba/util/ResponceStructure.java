package com.school.sba.util;

import org.springframework.stereotype.Component;

@Component
public class ResponceStructure<T> {
	private int status;
	private String username;
	private String password;
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
