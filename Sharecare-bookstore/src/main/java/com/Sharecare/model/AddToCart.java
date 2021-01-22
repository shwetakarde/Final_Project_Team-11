package com.Sharecare.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AddToCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartid;
//	private String cdate;
	
//	@ManyToOne
//	@JoinColumn(name = "bookId")
//	private Book book;
	
	
	
//	@ManyToOne
//	@JoinColumn(name = "id")
//	private User user;
	private int bookId;
	private int id;
	private String bookTitle;
	private String bookAuthor;
	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddToCart(int cartid, int bookId, int id, String bookTitle, String bookAuthor) {
		super();
		this.cartid = cartid;
		this.bookId = bookId;
		this.id = id;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "AddToCart [cartid=" + cartid + ", bookId=" + bookId + ", id=" + id + ", bookTitle=" + bookTitle
				+ ", bookAuthor=" + bookAuthor + "]";
	}
	
	
	
	
}
