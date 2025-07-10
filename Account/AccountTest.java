package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Account;
import com.aurionpro.model.AccountType;
import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.SavingAccount;

public class AccountTest {

	public static void main(String[] args) {
		try {
			System.out.println("Please provide few details for account opening : ");
			System.out.println("Enter name : ");
			Scanner scanner = new Scanner(System.in);
			String name = scanner.next();
			AccountType accountType;
			System.out.println("1. Saving account \n2. Current account");
			int accountTypeNumber = scanner.nextInt();
			Account account;
			if(accountTypeNumber == 1) {
				accountType = AccountType.Saving;
				System.out.println("Please provide your intial amount : ");
				int balance = scanner.nextInt();
				account = new SavingAccount("095601210212",name,balance);
			}
			else {
				accountType = AccountType.Current;
				System.out.println("Please provide your intial amount : ");
				int balance = scanner.nextInt();
				System.out.println("Please provide overdraft limit : ");
				int overdraftLimit = scanner.nextInt();
				account = new CurrentAccount("059601010202",name,balance,overdraftLimit);
			}
			
			while(true) {
				System.out.println("1. Credit\n2. Debit\n3. Account details\n4. Exit");
				int input = scanner.nextInt();
				if(input == 4)
					break;
				switch(input) {
				case 1: System.out.println("Enter your amount for credit : ");
						int amount = scanner.nextInt();
						account.credit(amount);
						break;
				case 2 : System.out.println("Enter your amount for debit : ");
						amount = scanner.nextInt();
						account.debit(amount);
						break;
				case 3 : account.toString();
						break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		finally {
			System.out.println("Please enter valid number only");
		}
		
	}

}
