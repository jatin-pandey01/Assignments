package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.interfaces.IMenu;

public class ItalianMenu implements IMenu {
	
	private static List<Food> foods;
	private IMenu menu;
	
	static {
		foods = new ArrayList<>();
		foods.add(new Food("Bruschetta", "Starter", "Veg", 150.00, 5));
		foods.add(new Food("Caprese Salad", "Starter", "Veg", 180.00, 10));
		foods.add(new Food("Margherita Pizza", "Main Course", "Veg", 320.00, 15));
		foods.add(new Food("Spaghetti Bolognese", "Main Course", "Non-Veg", 380.00, 10));
		foods.add(new Food("Tiramisu", "Dessert", "Veg", 200.00, 0));
	}

	@Override
	public void displayMenu() {
		System.out.printf("\n%-5s %-20s %-15s %-10s %-8.2s %-10s\n","ID","Name","Category","Meal","Price","Discount");
		for(Food food : foods) {
			System.out.printf("%-5s %-20s %-15s %-10s ₹%-8.2f %.1f%%\n",food.getId(), food.getName(),food.getCategory(),food.getMeal(),food.getPrice(),food.getDiscount());
		}
	}
	
	@Override
	public void addFood(String name, String category, String meal, double price, double discount) {
		foods.add(new Food(name, category, meal, price, discount));
	}
	
	@Override
	public Food getIdFood(int id) {
		menu = new ItalianMenu();
		for(Food food : foods) {
			if(food.getId() == id) {
				return food;
			}
		}
		
		menu = new IndianMenu();
		
		for(Food food : menu.getFood()) {
			if(food.getId() == id) {
				return food;
			}
		}
		return null;
	}
	
	@Override
	public List<Food> getFood() {
		return foods;
	}
	
	@Override
	public void removeFood(int id) {
		List<Food> foods1 = new ArrayList<>();
		menu = new ItalianMenu();
		for(Food food : menu.getFood()) {
			if(food.getId() != id) {
				foods1.add(food);
			}
		}
		
		if(foods1.size() != menu.getFood().size()) {
			setMenu(foods1);
			System.out.println("Food removed successfully from the menu.");
			return;
		}
		
		foods1 = new ArrayList<>();
		menu = new IndianMenu();
		for(Food food : menu.getFood()) {
			if(food.getId() != id) {
				foods1.add(food);
			}
		}
		
		if(foods1.size() != menu.getFood().size()) {
			setMenu(foods1);
			System.out.println("Food removed successfully from the menu.");
			return;
		}
		System.out.println("Sorry, no food exist with the given id in menu.");
	}

	@Override
	public void setMenu(List<Food> foods) {
		this.foods = foods;
	}

}
