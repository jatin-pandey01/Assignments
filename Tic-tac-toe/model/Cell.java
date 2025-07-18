package com.aurionpro.model;

public class Cell {
	private char value;
	
	public Cell() {
		value = ' ';
	}
	
	public char getValue() {
		return value;
	}
	
	public void setValue(char value) {
		try {
			if(this.value != ' ') {
				throw new IllegalStateException();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		this.value = value;
	}
}
