package com.aurionpro.model;

import com.aurionpro.interfaces.IDiscount;

public class VegJuly implements IDiscount {
	private String name = "VEGJULY";
	private String description = "Flat 15% discount on each order.";
	private double discount = 15;
	
	@Override
	public double applyDiscount() {
		return discount;
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
