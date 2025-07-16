package com.aurionpro.exceptions;

public class UpiException extends RuntimeException {
	
	public String getMessage() {
		return "Invalid Upi id!";
	}
	
}
