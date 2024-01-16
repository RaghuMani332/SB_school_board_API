package com.school.sba.util;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
public class ExceptionResponce<T> {
	private int status;
	private String message;
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRootCause() {
		return rootCause;
	}
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}
	private String rootCause;
}
