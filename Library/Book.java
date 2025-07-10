package com.aurionpro.model;

public class Book implements Comparable<Book> {
	private String name, bookId, authorName, publicationName;

	public Book(String name, String bookId, String authorName, String publicationName) {
		this.name = name;
		this.bookId = bookId;
		this.authorName = authorName;
		this.publicationName = publicationName;
	}
	
	public Book() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublicationName() {
		return publicationName;
	}

	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", bookId=" + bookId + ", authorName=" + authorName + ", publicationName="
				+ publicationName + "]";
	}

	@Override
	public int compareTo(Book book) {
		return this.getName().compareTo(book.getName());
	}
	
}
