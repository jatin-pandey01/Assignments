package com.aurionpro.model;

import com.aurionpro.exceptions.NegativeAmountException;
import com.aurionpro.exceptions.OverdraftLimitReachException;

public class CurrentAccount implements Account {
	private String accountNumber, name;
	private int balance, overdraftLimit, overdraftAmount = 0;
	
	
	public CurrentAccount(String accountNumber, String name, int balance, int overdraftLimit) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.overdraftLimit = overdraftLimit;
	}
	
	public void credit(int amount) {
		if(amount < 0) {
			throw new NegativeAmountException(amount);
		}
		if(amount >= overdraftAmount) {
			balance += (amount - overdraftAmount);
			overdraftAmount = 0;
			System.out.println(amount + "rs have successfully credited in your account");
			return;
		}
		overdraftAmount -= amount;
	}
	
	public void debit(int amount) {
		if(amount < 0) {
			throw new NegativeAmountException(amount);
		}
		if(overdraftAmount >= overdraftLimit) {
			throw new OverdraftLimitReachException(overdraftLimit);
		}
		if(balance >= amount) {
			balance -= amount;
			System.out.println("Please collect your cash.");
			return;
		}
		if(amount - balance + overdraftAmount >= overdraftLimit) {
			throw new OverdraftLimitReachException(overdraftLimit);
		}
		overdraftAmount += amount - balance;
		System.out.println("Please collect your cash.");
	}

	@Override
	public String toString() {
		return "CurrentAccount [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance
				+ ", overdraftLimit=" + overdraftLimit + ", overdraftAmount=" + overdraftAmount + "]";
	}
	
	
	
}
