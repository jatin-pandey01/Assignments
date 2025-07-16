package com.aurionpro.controller;

import java.util.Scanner;

import com.aurionpro.interfaces.IMenu;
import com.aurionpro.model.IndianMenu;
import com.aurionpro.model.ItalianMenu;
import com.aurionpro.model.User;

public class AdminController {
	private User user;
	private IMenu menu;
	Scanner scanner = new Scanner(System.in);
	
	public AdminController(User user) {
		this.user = user;
	}
	
	public void display() {
		try {
			System.out.println("Welcome " + user.getName());
			while(true) {
				System.out.println("\nPlease select any number from below :: ");
				System.out.println("\n1. Indian Menu\n2. Italian Menu\n3. Add food in Indian Menu\n4. Add food in Italian Menu\n5. Remove food \n6. Logout");
				int input = scanner.nextInt();
				if(input < 0 || input > 6) {
					System.out.println("Wrong input!!!");
					continue;
				}
				if(input == 6) {
					return;
				}
				
				if(input == 1) {
					showIndianMenu();
					continue;
				}
				if(input == 2) {
					showItalianMenu();
					continue;
				}
				if(input == 3) {
					addMenu(3);
					continue;
				}
				if(input == 4) {
					addMenu(4);
					continue;
				}
				if(input == 5) {
					removeMenu();
				}
				
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public void showIndianMenu(){
		menu = new IndianMenu();
		menu.displayMenu();
	}
	
	public void showItalianMenu() {
		menu = new ItalianMenu();
		menu.displayMenu();
	}
	
	public void addMenu(int menuInput) {
		try {
			System.out.println("Enter following things for adding new food :: ");
			System.out.println("Food name : ");
			String name = scanner.next();
			System.out.println("Food category(e.g., Starter, Main Courser, Dessert) : ");
			String category = scanner.next();
			System.out.println("Food meal(Veg/Non-Veg) : ");
			String meal = scanner.next();
			System.out.println("Food price : ");
			double price = scanner.nextDouble();
			System.out.println("Food discount : ");
			double discount = scanner.nextDouble();
			if(menuInput == 3)
				menu = new IndianMenu();
			else
				menu = new ItalianMenu();
			menu.addFood(name, category, meal, price, discount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void removeMenu() {
		System.out.println("Food id :: ");
		int id = scanner.nextInt();
		menu = new IndianMenu();
		menu.removeFood(id);
	}
	
}
