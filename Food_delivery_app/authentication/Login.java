package com.aurionpro.authentication;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.aurionpro.exceptions.EmailException;
import com.aurionpro.model.User;

public class Login {
	public static User login(String email, String password) {
		
		while(true) {
			try {
				
				FileInputStream fileInputStream = new FileInputStream("Register.dat");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				User user = (User) objectInputStream.readObject();
				if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
					return user;
				}
				else return null;
			} catch (Exception e) {
				System.out.println("Error : " + e.getMessage());
				return null;
			}
		}
	}
}
