package com.Sharecare.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContactUs {
	
	@Id
	private String cemail;
	private String message;
	public ContactUs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactUs(String cemail, String message) {
		super();
		this.cemail = cemail;
		this.message = message;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ContactUs [cemail=" + cemail + ", message=" + message + "]";
	}
	
	
	
	
	
	
}
