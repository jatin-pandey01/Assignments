package com.aurionpro.exceptions;

public class NegativeAmountException extends RuntimeException {

	private int amount;

	public NegativeAmountException(int amount) {
		super();
		this.amount = amount;
	}
	
	public String getMessage() {
		return "Your amount : " + amount + " is negative, please provide positive value and multiple of 100";
	}
	
}
