package com.aurionpro.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.authentication.Registration;
import com.aurionpro.exceptions.EmailException;
import com.aurionpro.exceptions.MobileNumberException;

public class User implements Serializable {
	private String name, email, password, mobileNumber;
	private UserType userType;
	private List<Order> orders;

	public User(String name, String email, String password, String mobileNumber, UserType userType) {
		super();
		try {
			if(mobileNumber.length() < 10) {
				throw new MobileNumberException();
			}
			
			if(!email.contains("@") || (email.indexOf("@") > email.lastIndexOf("."))) {
				throw new EmailException("Invalid email!!!!");
			}
			
			this.name = name;
			this.email = email;
			this.password = password;
			this.mobileNumber = mobileNumber;
			this.userType = userType;
			orders = new ArrayList<>();
			Registration.register(this);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public UserType getUserType() {
		return userType;
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", mobileNumber=" + mobileNumber
				+ ", userType=" + userType + "]";
	}
	
	
}
