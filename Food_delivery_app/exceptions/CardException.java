package com.aurionpro.exceptions;

public class CardException extends RuntimeException {
	private String message;
	
	public CardException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
