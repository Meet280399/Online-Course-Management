package com.course_management.exception;

public class StudentNotFoundException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StudentNotFoundException(String message) {
		super(message);
	}
}
