package com.aurionpro.model;

import com.aurionpro.exceptions.MinimumBalanceViolationException;
import com.aurionpro.exceptions.NegativeAmountException;

public class SavingAccount implements Account {
	private String accountNumber, name;
	int balance, minimumBalance = 1000;
	
	public SavingAccount(String accountNumber, String name, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		if(balance < minimumBalance)
			throw new MinimumBalanceViolationException(minimumBalance);
		this.balance = balance;
	}
	
	public void debit(int amount) {
		if(amount < 0) {
			throw new NegativeAmountException(amount);
		}
		if(balance-amount < 1000) {
			throw new MinimumBalanceViolationException(minimumBalance);
		}
		
		balance -= amount;
	}
	
	public void credit(int amount) {
		if(amount < 0) {
			throw new NegativeAmountException(amount);
		}
		balance += amount;
	}

	@Override
	public String toString() {
		return "SavingAccount [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance
				+"]";
	}
	
	
	
}
