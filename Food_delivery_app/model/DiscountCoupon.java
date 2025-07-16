package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.interfaces.IDiscount;

public class DiscountCoupon {
	private List<IDiscount> discounts;
	
	public DiscountCoupon() {
		discounts = new ArrayList<>();
		discounts.add(new July());
		discounts.add(new VegJuly());
	}
	
	public double applyDiscount(String discountCode) {
		for(IDiscount discount:discounts) {
			if(discount.getName().equalsIgnoreCase(discountCode))
				return discount.applyDiscount();
		}
		return -1;
	}
	
	public void showDiscount() {
		System.out.println("There " + (discounts.size() > 1 ? "are total" : "is ") + discounts.size() + " available." );
		for(IDiscount discount : discounts) {
			System.out.println(discount.getName() + " ::\t" + discount.getDiscountDescription());
		}
	}
}
