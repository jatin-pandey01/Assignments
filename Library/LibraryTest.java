package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Library;

public class LibraryTest {

	public static void main(String[] args) {

		Library library = new Library();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n\n1. Show All Available Books\n2. Show All Issued Books\n3. Check whether book is present in library or not\n4. Issue book by Name\n5. Issue book by Id\n6. Return book by Name\n7. Return book by Id\n8. Sort in Ascending order\n9. Sort in Descending order\n10. Exit");
			int input = scanner.nextInt();
			if(input == 10) break;
			switch(input) {
			case 1 : library.showAllAvailableBooks();
					break;
			case 2 : library.showAllIssuedBooks();
					break;
			case 3 : System.out.println("Please write book name which you want to search : ");
					String name = scanner.next();
					int num = library.isAvailableInLibrary(name);
					break;
			case 4 : System.out.println("Please write book name which you want to issue : ");
					name = scanner.next();
					library.issueBookByName(name);
					break;
			case 5 : System.out.println("Please write book id which you want to issue : ");
					String id = scanner.next();
					library.issueBookById(id);
					break;
			case 6: System.out.println("Please write book name which you want to return : ");
					name = scanner.next();
					library.returnBookByName(name);
					break;
			case 7 : System.out.println("Please write book name which you want to return : ");
					id = scanner.next();
					library.returnBookById(id);
					return;
			case 8 : library.sortedInAscendingByName();
					break;
			case 9 : library.sortedInDescendingByName();
					break;
			default:break;
			}
		}
		
	}

}
