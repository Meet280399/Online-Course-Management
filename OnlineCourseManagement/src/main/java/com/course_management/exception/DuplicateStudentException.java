package com.course_management.exception;

public class DuplicateStudentException extends Exception {

	private String message;
	
	public DuplicateStudentException(String message) {
		super(message);
	}

}
