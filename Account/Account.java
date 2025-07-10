package com.aurionpro.model;

public interface Account {

	void debit(int amount);
	void credit(int amount);
	String toString();
	
}
