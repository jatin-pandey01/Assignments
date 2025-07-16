package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<FoodItem> foods;
	private DiscountCoupon discount;
	private double totalPrice = 0;
	private double discountAmount = -1;
	private double priceLeft = 0;
	
	public Order() {
		discount = new DiscountCoupon();
		foods = new ArrayList<>();
	}
	
	public void addFood(Food food, int quantity) {
		foods.add(new FoodItem(food,quantity));
		totalPrice += (quantity*food.getPrice());
	}
	
	public void showDiscount() {
		discount.showDiscount();
	}
	
	public void applyDiscount(String discountCode) {
		if(discountAmount != -1) {
			System.out.println("You have already applied discount code.");
			return;
		}
		double discountPercentage = discount.applyDiscount(discountCode);
		if(discountPercentage > 0) {
			discountAmount = (discountPercentage * totalPrice)/100;
			totalPrice -= discountAmount;
			System.out.println("Cheer! You got discount of " + discountAmount + "rs");
			return;
		}
		System.out.println("Wrong coupon code.");
	}
	
	public void removeDiscount() {
		totalPrice += discountAmount;
		discountAmount = -1;
	}
	
	public double getPrice() {
		return priceLeft = discountAmount == -1 ? totalPrice : totalPrice + discountAmount;
	}
	
	public double getDiscountAmount() {
		return discountAmount == -1 ? 0 : discountAmount;
	}
	
	public List<FoodItem> getFoods(){
		return foods;
	}
	
	public double getPriceLeft() {
		return priceLeft;
	}
	
	public void setPriceLeft(double price) {
		this.priceLeft = price;
	}
	
}
