package com.aurionpro.exceptions;

public class FoodIdException extends RuntimeException {
	
	public String getMessage(String id) {
		return "Sorry, your food id " + id + " does not exist in menu.";
	}
	
}
