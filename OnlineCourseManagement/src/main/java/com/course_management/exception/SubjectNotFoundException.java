package com.course_management.exception;

public class SubjectNotFoundException extends Exception {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public SubjectNotFoundException(String message) {
		super(message);
	}
}
