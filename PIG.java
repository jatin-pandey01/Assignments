package com.aurionpro.model;

import java.util.Scanner;

public class PIG {
//	private int score, turn = 5;
	private Integer score = 0, turn = 5, cnt = 1;
	Scanner scanner = new Scanner(System.in);
	
	public void start() {
		if(turn <= 0) {
			System.out.println("You have lost, try next time.");
			return;
		}
		turnStart();
	}
	
	public void turnStart() {
		if(score >= 20) {
			System.out.println("Total score : " + score+"\nYou finished in " + (cnt) + " turns");
			return;
		}
		System.out.println("Roll or hold ? press 1 for Roll and press 2 for Hold : ");
		int input = scanner.nextInt();
		if(input == 2) {
			turn--;
			cnt++;
			System.out.println("Total score = "+score);
			start();
			return;
		}
		int dice = (int)(Math.random()*(6-1+1) + 1);
		System.out.println("Die : " + dice);
		if(dice == 1) {
			score=0;
			turn--;
			cnt++;
			System.out.println("Turn over. No score.");
			start();
			return;
		}
		score += dice; 
		turnStart();
	}
}
