package com.aurionpro.exceptions;

public class EmailException extends RuntimeException {
	private String message;
	
	public EmailException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
