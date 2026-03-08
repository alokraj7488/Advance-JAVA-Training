package com.library_book.inventory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "library_books")
public class Book {
	@Id
	@Column(name = "book_id")
	private int bookId;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "author_name", nullable = false)
	private String authorName;
	
	private String genre;
	private double price;
	
	@Column(name = "availability_status")
	private String availableStatus;
	
	@Column(name = "published_year")
	private int publishedYear;
	
	

	public Book() {

	}

	public Book(int bookId, String title, String authorName, String genre, double price, String availableStatus,
			int publishedYear) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.authorName = authorName;
		this.genre = genre;
		this.price = price;
		this.availableStatus = availableStatus;
		this.publishedYear = publishedYear;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAvailableStatus() {
		return availableStatus;
	}

	public void setAvailableStatus(String availableStatus) {
		this.availableStatus = availableStatus;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", authorName=" + authorName + ", genre=" + genre
				+ ", price=" + price + ", availableStatus=" + availableStatus + ", publishedYear=" + publishedYear
				+ "]";
	}
	
	
}
