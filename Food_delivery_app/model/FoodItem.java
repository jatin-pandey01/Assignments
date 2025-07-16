package com.aurionpro.model;

public class FoodItem {
	private Food food;
	private int quantity;
	
	public FoodItem(Food food, int quantity) {
		this.food = food;
		this.quantity = quantity;
	}

	public Food getFood() {
		return food;
	}


	public int getQuantity() {
		return quantity;
	}
	
}
