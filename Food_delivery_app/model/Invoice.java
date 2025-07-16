package com.aurionpro.model;

import java.util.List;

public class Invoice {
	private Order order;
	private User user;
	
	public Invoice(Order order, User user) {
		this.order = order;
		this.user = user;
	}
	
	public void getInvoice(double totalPrice, double discountPrice) {
		System.out.println("\n\n-----------------------------------------");
		System.out.println("|\tAurionpro Restaurant \n-----------------------------------------");
		
		System.out.println("Name : " + user.getName() + "\nEmail : " + user.getEmail() + "\nMobile : " + user.getMobileNumber());
		List<FoodItem> foods = order.getFoods();
		System.out.println("Total order :: " + foods.size());
		System.out.println("Total Price :: " + totalPrice);
		System.out.println("Total discount price :: " + discountPrice);
		System.out.println("After discount :: " + (totalPrice-discountPrice));
		System.out.println("GST :: " + (5*(totalPrice-discountPrice))/100);
		System.out.println("Net amount :: " + ((totalPrice-discountPrice) + (5*(totalPrice-discountPrice))/100));
	}
	
}
