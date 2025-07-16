package com.aurionpro.interfaces;

import java.util.List;

import com.aurionpro.model.Food;

public interface IMenu {
	public void displayMenu();
	public Food getIdFood(int id);
	public List<Food> getFood();
	void addFood(String name, String meal, String category, double price, double discount);
	void removeFood(int id);
	void setMenu(List<Food> foods);
}
