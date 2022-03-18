package com.course_management.exception;

import java.time.LocalDateTime;

public class ErrorInformation {

	private String message;
	private String url;
	private LocalDateTime date;
	private String validationMsg;

//	Here we created constructor for ErrorInformation class and getters and setters for all ErrorInformation variables.

	public ErrorInformation(String message, String url, LocalDateTime date, String validationMsg) {
		super();
		this.message = message;
		this.url = url;
		this.date = date;
		this.validationMsg = validationMsg;
	}

	public ErrorInformation(String message, String url, LocalDateTime date) {
		super();
		this.message = message;
		this.url = url;
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getValidationMsg() {
		return validationMsg;
	}

	public void setValidationMsg(String validationMsg) {
		this.validationMsg = validationMsg;
	}

}
