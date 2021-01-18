package com.Sharecare.model;


import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Admin{
	
	@Id
	private int id;
	private String adminEmail;
	private String adminPassword;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int id, String adminEmail, String adminPassword) {
		super();
		this.id = id;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminEmail=" + adminEmail + ", adminPassword=" + adminPassword + "]";
	}
	
	
	
}