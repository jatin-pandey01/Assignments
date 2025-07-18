package com.aurionpro.model;

import java.util.Scanner;

public class Game {
	private Cell board[][] = new Cell[3][3];
	private boolean isEnded;
	private char currentValue;
	Scanner scanner = new Scanner(System.in);
	private Player player1, player2;
	
	public Game(Player player1, Player player2) {
		
		for(int i = 0; i < board.length; i++) {
			
			for(int j = 0; j < board[0].length; j++) {
				
				board[i][j] = new Cell();
				
			}
			
		}
		
		isEnded = false;
		currentValue = 'X';
		this.player1 = player1;
		this.player2 = player2;
		
	}
	
	public void start() {
		
		System.out.println("***** Welcome to Tic-Tac-Toe *****");
		
		System.out.println("Who want to start? " + player1.getName() + " or " + player2.getName() + "\nEnter player name : ");
		String name = scanner.next();
		
		while( !(name.equals(player1.getName()) || name.equals(player2.getName()) )) {
			System.out.println("Please enter corrent name.");
			name = scanner.next();
		}
		
		if(name.equals(player2.getName())) {
			
			Player tempPlayer = player1;
			player1 = player2;
			player2 = tempPlayer;
			
		}
		
		while(!isEnded) {
			
			printBoard();
			
			name = (currentValue == 'X' ? player1.getName() : player2.getName());
			
			System.out.println(name + ", enter your move (row and column) ");
			
			int row,column;
			try {
				row = scanner.nextInt()-1;
				column = scanner.nextInt()-1;
			} catch (Exception e) {
				System.out.println("Must be integer.");
				continue;
			}
			
			if(isValidMove(row, column)) {
				
				board[row][column].setValue(currentValue);
				
				if(checkWin()) {
					
					printBoard();
					System.out.println("Congrats," + name +"!, you wins");
					isEnded = true;
					
				}
				else if(isBoardFull()) {
					
					printBoard();
					System.out.println("The game is  draw!");
					
				}
				else {
					
					switchValue();
					
				}
				
			}
			
		}
		
	}
	
	public void printBoard() {
		
		System.out.println("  1 2 3");
		
        for (int i = 0; i < 3; i++) {
        	
            System.out.print((i+1) + " ");
            
            for (int j = 0; j < 3; j++) {
            	
                System.out.print((board[i][j].getValue() == ' ' ? "-" : board[i][j].getValue()));
                
                if (j < 2) 
                	System.out.print("|");
                
            }
            
            System.out.println();
            
            if (i < 2) System.out.println("  -----");
            
        }
		
	}
	
	public boolean isValidMove(int row, int column) {
		
		if(row < 0 || row >= 3) {
			System.out.println("Invalid row. Try again.");
			return false;
		}
		
		if(column < 0 || column >= 3) {
			System.out.println("Invalid column. Try again.");
			return false;
		}
		
		if(board[row][column].getValue() != ' ') {
			System.out.println("Already marked at this position. Try again.");
			return false;
		}
		
		return true;
	}
	
	public boolean isBoardFull() {
		
		for(int i = 0; i < board.length; i++) {
			
			for(int j = 0; j < board[0].length; j++) {
				
				if(board[i][j].getValue() == ' ')
					return false;
				
			}
		}
		
		return true;
	}
	
	public boolean checkWin() {
		
		for(int i = 0; i < board.length; i++) {
			
			if(board[i][0].getValue() == currentValue 
					&& board[i][1].getValue() == currentValue 
					&& board[i][2].getValue() == currentValue) {
				return true;
			}
			
		}
		
		for(int i = 0; i < board.length; i++) {
			
			if(board[0][i].getValue() == currentValue 
					&& board[1][i].getValue() == currentValue 
					&& board[2][i].getValue() == currentValue) {
				return true;
			}
			
		}
		
		if(board[0][0].getValue() == currentValue 
				&& board[1][1].getValue() == currentValue 
				&& board[2][2].getValue() == currentValue) {
			return true;
		}
		
		if(board[0][2].getValue() == currentValue 
				&& board[1][1].getValue() == currentValue 
				&& board[2][0].getValue() == currentValue) {
			return true;
		}
		
		return false;
	}
	
	public void switchValue() {
		
		if(currentValue == 'X') {
			currentValue = 'O';
			return;
		}
		
		currentValue = 'X';
		
	}
	
}
