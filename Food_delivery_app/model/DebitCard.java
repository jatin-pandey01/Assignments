package com.aurionpro.model;

import com.aurionpro.interfaces.IPayment;

public class DebitCard implements IPayment {
	
	private String cardNumber, name, expiryDate, Cvv;

	public DebitCard(String cardNumber, String name, String expiryDate, String cvv) {
		super();
		this.cardNumber = cardNumber;
		this.name = name;
		this.expiryDate = expiryDate;
		Cvv = cvv;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Payment of " + amount + "rs done through XXXX-XXXX-XXXX-" + cardNumber.substring(12) +" debit card.");
	}

}
