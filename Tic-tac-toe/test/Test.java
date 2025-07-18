package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Game;
import com.aurionpro.model.Player;

public class Test {
	
	public static char currenValue = 'X';
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter player1 name : ");
		String name1 = scanner.next();
		System.out.println("Enter player2 name : ");
		String name2 = scanner.next();
		
		Player player1 = new Player(name1);
		Player player2 = new Player(name2);
	
		Game game = new Game(player1,player2);
		
		while(true) {
			game.start();
			System.out.println("Want to play again ?\n 1. Yes \n 2. No");
			int input = scanner.nextInt();
			if(input == 2) 
				break;
		}
		
		scanner.close();
	}

}
