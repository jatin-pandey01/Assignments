package com.aurionpro.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
	private List<Book> availableBooks = new ArrayList<>();
	private List<Book> issuedBooks = new ArrayList<>();
	
	public Library() {
		availableBooks.add(new Book("Beating the Street","US001","Peter Lynch","Simon and Schuster"));
		availableBooks.add(new Book("The Warren Buffet way","US002","Robert G. Hagstrom","John Wiley & Sons"));
		availableBooks.add(new Book("The Psychology of Money","US003","Morgan Housel","Harriman house"));
		availableBooks.add(new Book("Think and Grow Rich","US004","Napoleon Hill","think-and-grow-rich-ebook.com"));
		availableBooks.add(new Book("Time Management","US005","Richard Walsh","Avon"));
		
		issuedBooks.add(new Book("Aryabhatiya of Aryabhata","IN001","Kripa Shankar Shukla","Vishveshvaranand Vedic Research Institue"));
		issuedBooks.add(new Book("India that is BHARAT","IN002","J Sai Deepak","Bloomsbury"));
		issuedBooks.add(new Book("The Discovery of India","IN003","Jawaharlal Nehru","Oxford University Press"));
		issuedBooks.add(new Book("Outlines of Indian Philosophy","IN004","M. Hiriyanna","Kavyalaya Publishers"));
		issuedBooks.add(new Book("INDIA : The Ancient Past","IN005","Burjor Avari","Routledge"));
	}
	
	public int isAvailableInLibrary(String name) {
		for(int i=0;i<availableBooks.size();i++) {
			if(availableBooks.get(i).getName().equalsIgnoreCase(name)) {
				System.out.println("Yes it is there in library and also available for reading.");
				return i;
			}
		}
		for(Book book : issuedBooks) {
			if(book.getName().equalsIgnoreCase(name)) {
				System.out.println("Yes it is there in library but someone has issued it.");
				return -1;
			}
		}
		System.out.println("Sorry, there is no book with this name.");
		return 0;
	}
	
	public void issueBookByName(String name) {
		int available = isAvailableInLibrary(name);
		if(available >= 0) {
			Book issueBook = availableBooks.remove(available);
			issuedBooks.add(issueBook);
		}
	}
	
	public void returnBookByName(String name) {
		for(int i=0;i<issuedBooks.size();i++) {
			if(issuedBooks.get(i).getName().equalsIgnoreCase(name)) {
				Book returnBook = issuedBooks.remove(i);
				availableBooks.add(returnBook);
				System.out.println("Thank you for visiting!");
				return;
			}
		}
		System.out.println("There is no such book issued, so how can you return?");
	}
	
	public void issueBookById(String id) {
		for(int i=0;i<issuedBooks.size();i++) {
			if(issuedBooks.get(i).getBookId().equalsIgnoreCase(id)) {
				Book returnBook = issuedBooks.remove(i);
				availableBooks.add(returnBook);
				System.out.println("Thank you for visiting!");
				return;
			}
		}
	}
	
	public void returnBookById(String id) {
		for(int i=0;i<issuedBooks.size();i++) {
			if(issuedBooks.get(i).getBookId().equalsIgnoreCase(id)) {
				Book returnBook = issuedBooks.remove(i);
				availableBooks.add(returnBook);
				System.out.println("Thank you for visiting!");
				return;
			}
		}
		System.out.println("There is no such book issued, so how can you return?");
	}
	
	public void showAllAvailableBooks() {
		for(Book book:availableBooks) {
			System.out.println(book);
		}
	}
	
	public void showAllIssuedBooks() {
		for(Book book:issuedBooks) {
			System.out.println(book);
		}
	}
	
	public void sortedInAscendingByName() {
		Collections.sort(availableBooks);
		Collections.sort(issuedBooks);
		System.out.println("Available books in sorted order : ");
		showAllAvailableBooks();
		System.out.println("Issued books in sorted order : ");
		showAllIssuedBooks();
	}
	
	public void sortedInDescendingByName() {
		Collections.sort(availableBooks);
		Collections.sort(issuedBooks);
		Collections.reverse(availableBooks);
		Collections.reverse(issuedBooks);
		System.out.println("Available books in sorted order : ");
		showAllAvailableBooks();
		System.out.println("Issued books in sorted order : ");
		showAllIssuedBooks();
	}
	
}
