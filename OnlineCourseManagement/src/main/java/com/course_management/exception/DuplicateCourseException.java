package com.course_management.exception;

public class DuplicateCourseException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DuplicateCourseException(String message) {
		super(message);
	}
}
