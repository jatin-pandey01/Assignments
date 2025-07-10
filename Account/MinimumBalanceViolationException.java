package com.aurionpro.exceptions;

public class MinimumBalanceViolationException extends RuntimeException {
	private int minimumBalance;

	public MinimumBalanceViolationException(int minimumBalance) {
		super();
		this.minimumBalance = minimumBalance;
	}
	
	public String getMessage() {
		return "Minimum balance of " + minimumBalance + "rs must be there in an account.";
	}
}
