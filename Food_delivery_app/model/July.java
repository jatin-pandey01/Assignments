package com.aurionpro.model;

import com.aurionpro.interfaces.IDiscount;

public class July implements IDiscount {
	private String name = "JULY10";
	private String description = "Flat 10% discount on each order.";

	@Override
	public double applyDiscount() {
		return 10;
	}


	@Override
	public String getDiscountDescription() {
		return description;
	}


	@Override
	public String getName() {
		return name;
	}
	
}
