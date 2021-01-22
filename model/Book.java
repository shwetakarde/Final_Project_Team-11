package com.Sharecare.model;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	@Column(name = "Book_Title")
	private String bookTitle;
	private String bookAuthor;
	private int noOfPages;
	private String bookDescription;
	private String bookImage;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="id",nullable = false)
//	private User user;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	public Book() {
		super();
	}

	public Book(int bookId, String bookTitle, String bookAuthor, int noOfPages, String bookDescription,
			String bookImage, Category category) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.noOfPages = noOfPages;
		this.bookDescription = bookDescription;
		this.bookImage = bookImage;
		this.category = category;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", noOfPages="
				+ noOfPages + ", bookDescription=" + bookDescription + ", bookImage=" + bookImage + ", category="
				+ category + "]";
	}
	
	
	
	
	

	
}
