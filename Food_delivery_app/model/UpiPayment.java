package com.aurionpro.model;

import com.aurionpro.interfaces.IPayment;

public class UpiPayment implements IPayment {
	
	String upiId, name;
	
	public UpiPayment(String upiId, String name) {
		this.upiId = upiId;
		this.name = name;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Payment of " + amount + "rs done through " + upiId +" UPI.");		
	}

}
