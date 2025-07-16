package com.aurionpro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import com.aurionpro.exceptions.CardException;
import com.aurionpro.exceptions.UpiException;
import com.aurionpro.interfaces.IMenu;
import com.aurionpro.interfaces.IPayment;
import com.aurionpro.model.CreditCard;
import com.aurionpro.model.DebitCard;
import com.aurionpro.model.DeliveryPartner;
import com.aurionpro.model.DeliveryPartners;
import com.aurionpro.model.Food;
import com.aurionpro.model.FoodItem;
import com.aurionpro.model.IndianMenu;
import com.aurionpro.model.Invoice;
import com.aurionpro.model.ItalianMenu;
import com.aurionpro.model.Order;
import com.aurionpro.model.UpiPayment;
import com.aurionpro.model.User;

public class UserController {
	private User user;
	private IMenu menu;
	private HashMap<Integer,Integer> mapOfOrderWithQuantity;
	private Order order;
	private double totalPrice, discountPrice;
	Scanner scanner = new Scanner(System.in);
	private List<DeliveryPartner> deliveryPartners;
	
	public UserController(User user) {
		mapOfOrderWithQuantity = new HashMap<>();
		order = new Order();
		menu = new IndianMenu();
		this.user = user;
		totalPrice = 0;
		discountPrice = 0;
		deliveryPartners = new DeliveryPartners().getDeliveryPartners();
	}
	
	public void display() {
		try {
			System.out.println("\n\nWelcome " + user.getName());
			while(true) {
				System.out.println("\n\nPlease select any number from below :: ");
				System.out.println("1. Indian menu\n2. Italian menu\n3. Place order by Id\n4. Remove order by Id\n5. Check cart\n6. Checkout\n7. View previous order\n8. Logout");
				int input = scanner.nextInt();
				if(input < 0 || input > 8) {
					System.out.println("Wrong input!!!");
					continue;
				}
				if(input == 8) {
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
					System.out.println("Enter food id :: ");
					int id = scanner.nextInt();
					System.out.println("Quantity :: ");
					int quantity = scanner.nextInt();
					addOrder(id,quantity);
					continue;
				}
				if(input == 4) {
					System.out.println("Enter food id :: ");
					int id = scanner.nextInt();
					System.out.println("Quantity :: ");
					int quantity = scanner.nextInt();
					removeOrder(id,quantity);
					continue;
				}
				if(input == 5) {
					if(mapOfOrderWithQuantity.isEmpty()) {
						System.out.println("No order placed!!");
						continue;
					}
					checkOrderPlace();
				}
				if(input == 6) {
					if(mapOfOrderWithQuantity.isEmpty()) {
						System.out.println("No order placed!!");
						continue;
					}
					checkOut();
				}
				
				if(input == 7) {
					previousOrder();
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
	
	public void addOrder(int id, int quantity) {
		Food food = menu.getIdFood(id);
		if(food == null) {
			System.out.println("Sorry, your food id " + id + " does not exist in menu.");
			return;
		}
		if(mapOfOrderWithQuantity.get(id) == null) {
			mapOfOrderWithQuantity.put(id, quantity);
			return;
		}
		int initialQuantity = mapOfOrderWithQuantity.get(id);
		mapOfOrderWithQuantity.replace(id,initialQuantity + quantity);
	}
	
	public void removeOrder(int id, int quantity) {
		Food food = menu.getIdFood(id);
		if(food == null) {
			System.out.println("Sorry, your food id " + id + " does not exist in menu.");
			return;
		}
		if(mapOfOrderWithQuantity.get(id) == null) {
			System.out.println("Not in the cart.");
			return;
		}
		int initialQuantity = mapOfOrderWithQuantity.get(id);
		if(initialQuantity < quantity) {
			System.out.println("Remove quantity is more than ordered quantity, so just removing all and making zero order for this food.");
			mapOfOrderWithQuantity.remove(id);
			return;
		}
		mapOfOrderWithQuantity.replace(id, initialQuantity - quantity);
	}
	
	public void checkOrderPlace() {
		System.out.println("********** Order in the Card **********");
		System.out.printf("\n%-5s %-20s %-15s %-10s %-8.2s %-10s %-10s\n","ID","Name","Category","Meal","Price","Discount","Quantity");
		for(Entry<Integer, Integer> it:mapOfOrderWithQuantity.entrySet()) {
			Food food = menu.getIdFood(it.getKey());
			System.out.printf("%-5s %-20s %-15s %-10s ₹%-8.2f %.1f%%    X     %d\n",food.getId(), food.getName(),food.getCategory(),food.getMeal(),food.getPrice(),food.getDiscount(),it.getValue());
		}
	}
	
	public void checkOut(){
		order = new Order();
		System.out.printf("\n%-5s %-20s %-15s %-10s %-8.2s %-10s %-10s\n","ID","Name","Category","Meal","Price","Discount","Quantity");
		for(Entry<Integer, Integer> it:mapOfOrderWithQuantity.entrySet()) {
			Food food = menu.getIdFood(it.getKey());
			order.addFood(food, it.getValue());
			totalPrice += (food.getPrice() * it.getValue());
			System.out.printf("%-5s %-20s %-15s %-10s ₹%-8.2f %.1f%%         %d\n",food.getId(), food.getName(),food.getCategory(),food.getMeal(),food.getPrice(),food.getDiscount(),it.getValue());
		}
		user.addOrder(order);
		System.out.println("\nTotal amount :: " + totalPrice);
		discountPrice = (totalPrice >= 500 ? (0.15 * totalPrice) : 0);
		System.out.println("Discount amount :: " + discountPrice);
		System.out.println("Net amount :: " + (totalPrice-discountPrice));
		while(true) {
			if(payment((totalPrice-discountPrice) + ((5*(totalPrice-discountPrice))/100))) {
				break;
			}
		}
	}
	
	public boolean payment(double amount)  {
		try {
			IPayment payment = null;
			System.out.println("\n\nPlease select mode of payment :: \n1. Debit card\n2. Credit card\n3. UPI\n4. Cash on Delivery");
			int input = scanner.nextInt();
			while(input < 0 || input > 4) {
				System.out.println("Wrong input!!!!");
				System.out.println("Please select mode of payment :: \n1. Debit card\n2. Credit card\n3. UPI\n4. Cash on Delivery");
				input = scanner.nextInt();
			}
			if(input == 1) {
				System.out.println("\nDebit card number : ");
				String cardNumber = scanner.next();
				System.out.println("Debit card holder name(Only first name) : ");
				String name = scanner.next();
				System.out.println("Expiry date (in DD/MM format) : ");
				String expiryDate = scanner.next();
				System.out.println("CVV number : ");
				String cvv = scanner.next();
				
				if(cardNumber.length() != 16) {
					throw new CardException("Invalid Card! Debit Card number must be of 16 digit.");
				}
				
				payment = new DebitCard(cardNumber, name, expiryDate, cvv);
				payment.pay(amount);
			}
			else if(input == 2) {
				System.out.println("Credit card number : ");
				String cardNumber = scanner.next();
				System.out.println("Credit card holder name(Only first name) : ");
				String name = scanner.next();
				System.out.println("Expiry date (in DD/MM format) : ");
				String expiryDate = scanner.next();
				System.out.println("CVV number : ");
				String cvv = scanner.next();
				
				if(cardNumber.length() != 16) {
					throw new CardException("Invalid Card! Credit Card number must be of 16 digit.");
				}
				
				payment = new CreditCard(cardNumber, name, expiryDate, cvv);
				payment.pay(amount);
			}
			else if(input == 3) {
				System.out.println("Enter upi id : ");
				String upiId = scanner.next();
				System.out.println("Enter upi holder name : ");
				String name = scanner.next();
				
				if(!upiId.contains("@ok")) {
					throw new UpiException();
				}
				
				payment = new UpiPayment(upiId, name);
				payment.pay(amount);
			}
			
			System.out.println("\n\nDelivery Status: Out for Delivery");
			System.out.println("Delivery Rider Assigned: Ramesh Yadav");
			System.out.println("Rider Contact: +91-9876123456");
			System.out.println("Vehicle Number: DL01AB1234");
			int index = (int) Math.random() * (deliveryPartners.size()-1 - 0 + 1);
			System.out.println("Delivery Partner: " + deliveryPartners.get(index).getName());
			System.out.println("Estimated Delivery Time: 45 minutes");
			long time = 5000;
			Thread.sleep(time);
			System.out.println("Delivered!!!\nEnjoy your meal!");
			
			System.out.println("Hello => " + order.getFoods().size());
			Invoice invoice = new Invoice(order, user);
			invoice.getInvoice(totalPrice, discountPrice);
			order = null;
			order = new Order();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}
		
	}
	
	public void previousOrder() {
		List<Order> orders = user.getOrders();
		if(orders.isEmpty()) {
			System.out.println("You have not done any previous order.");
			return;
		}
		System.out.println("Total previous orders : " + orders.size());
		int countOrder = 1;
		for(Order order : orders) {
			System.out.println("\nOrder number :) " + countOrder);
			System.out.printf("\n%-5s %-20s %-15s %-10s %-8.2s %-10s %-10s\n","ID","Name","Category","Meal","Price","Discount","Quantity");
			List<FoodItem> foods = order.getFoods();
			for(FoodItem food : foods) {
				System.out.printf("%-5s %-20s %-15s %-10s ₹%-8.2f %.1f%%         %d\n",food.getFood().getId(), food.getFood().getName(),food.getFood().getCategory(),food.getFood().getMeal(),food.getFood().getPrice(),food.getFood().getDiscount(),food.getQuantity());

			}
		}
	}
	
}
