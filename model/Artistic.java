package com.Sharecare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Artistic")
public class Artistic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int artisticId;
	@Column(name = "Content")
	
	private String content;
//	@ManyToOne
////	@JoinColumn(name = "id")
//	private User user;
	
	public Artistic() {
		super();
	}
	public Artistic(int artisticId, String content, User user) {
		super();
		this.artisticId = artisticId;
		this.content = content;
//		this.user = user;
	}
	public int getArtisticId() {
		return artisticId;
	}
	public void setArtisticId(int artisticId) {
		this.artisticId = artisticId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	@Override
	public String toString() {
		return "Artistic [artisticId=" + artisticId + ", content=" + content + "]";
	}
	
	
	
	
	
}
