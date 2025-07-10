package com.aurionpro.exceptions;

public class OverdraftLimitReachException extends RuntimeException {

	private int overdraftAmount;

	public OverdraftLimitReachException(int overdraftAmount) {
		super();
		this.overdraftAmount = overdraftAmount;
	}
	
	public String getMessage() {
		return "You have reached the overdraft limit of " + overdraftAmount + "rs";
	}
	
}
