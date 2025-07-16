package com.aurionpro.model;

public class Food {
	private String name, category, meal;
	private int id;
	private double price;
	private double discount;
	private static int count = 1;
	
	public Food(String name, String category, String meal, double price, double discount) {
		super();
		this.id = count;
		count++;
		this.name = name;
		this.meal = meal;
		this.category = category;
		this.price = price;
		this.discount = discount;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getDiscount() {
		return discount;
	}

	@Override
	public String toString() {
//		System.out.printf("%-5d %-20s %-15s %-10s ₹%-10s %-8.2f%% ₹%-10.2f\n",id, name, category, meal, description,price,discount);
		return "Food :: id= " + id + " name=" + name + " | category=" + category + " | meal=" + meal + 
				" | price=" + price + " | discount=" + discount ;
//		return "Jatin";
	}
	
	
	
}
