package com.aurionpro.exceptions;

public class MobileNumberException extends RuntimeException {
	
	public String getMessage() {
		return "Mobile number must be 10 digits";
	}
	
}
