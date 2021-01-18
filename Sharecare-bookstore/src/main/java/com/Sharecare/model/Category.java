package com.Sharecare.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	
	private String categoryName;
	
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="category")
//	private Set<Book> book;
	
	public Category() {
		super();
	}
	public Category(int categoryId, String categoryName, Set<Book> book) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		//this.book = book;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
//	public Set<Book> getBook() {
//		return book;
//	}
//	public void setBook(Set<Book> book) {
//		this.book = book;
//	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	
	
}
