package com.course_management.exception;

public class NoSuchFeedbackException extends Exception {
	
	public String message;
	
	public NoSuchFeedbackException(String message) {
		super(message);
	}

}
