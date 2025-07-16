package com.aurionpro.test;

import java.io.IOException;
import java.util.Scanner;

import com.aurionpro.authentication.Login;
import com.aurionpro.authentication.Registration;
import com.aurionpro.controller.AdminController;
import com.aurionpro.controller.UserController;
import com.aurionpro.exceptions.EmailException;
import com.aurionpro.model.User;
import com.aurionpro.model.UserType;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		User user = null;
		System.out.println(" ------------------------------------------------");
		System.out.println("|\t Welcome to Aurionpro Restaurant \t |");
		System.out.println(" ------------------------------------------------");
		try {
			while(true) {
				System.out.println("\n1. Customer Login\n2. Customer Register\n3. Admin Login\n4. Exit");
				int input = scanner.nextInt();
				if(input < 0 || input > 4) {
					System.out.println("Wrong input!!!");
					continue;
				}
				if(input == 4) {
					System.out.println("*** Thank you for visiting ***");
					break;
				}
				
				if(input == 1) {
					System.out.println("Email id : ");
					String email = scanner.next();
					System.out.println("Password : ");
					String password = scanner.next();
					try {
						if(!email.contains("@") || (email.indexOf("@") > email.lastIndexOf("."))) {
							throw new EmailException("Invalid email!!!!");
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
					user = Login.login(email, password);
					if(user == null) {
						System.out.println("User does not exist.");
						continue;
					}
					
					UserController userController = new UserController(user);
					userController.display();
					user = null;
					
					continue;
				}
				if(input == 2) {
					System.out.println("Name : ");
					String name = scanner.next();
					System.out.println("Email : ");
					String email = scanner.next();
					System.out.println("Password : ");
					String password = scanner.next();
					System.out.println("Mobile number : ");
					String mobileNumber = scanner.next();
					
					user = new User(name, email, password, mobileNumber, UserType.Customer);
					
					continue;
				}
				
				if(input == 3) {
					System.out.println("Admin email : ");
					String email = scanner.next();
					System.out.println("Admin password : ");
					String password = scanner.next();
					
					if(email.equals("admin@gmail.com") && password.equals("Admin#123")) {
						AdminController adminController = new AdminController(new User("Admin", "admin@gmail.com", "Admin#123", "9890878000", UserType.Admin));
						adminController.display();
						user = null;
					}
					else {
						System.out.println("Invalid credentials !!!");
					}
				}
			}
		} 
		catch (Exception e) {
			System.out.println("Test : " + e.getLocalizedMessage());
		}
		finally {
			scanner.close();
		}
	}

}
