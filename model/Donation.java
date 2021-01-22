package com.Sharecare.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.*;


@Entity
public class Donation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int donationid;
	private String demail;
	private String ddate;
	private String paymentmode;
	private int amount;
	
	public Donation() {
		super();
	}
	
	public Donation(int donationid, String demail, String ddate, String paymentmode, int amount) {
		super();
		this.donationid = donationid;
		this.demail = demail;
		this.ddate = ddate;
		this.paymentmode = paymentmode;
		this.amount = amount;
	}
	public int getDonationid() {
		return donationid;
	}
	public void setDonationid(int donationid) {
		this.donationid = donationid;
	}
	public String getDemail() {
		return demail;
	}
	public void setDemail(String demail) {
		this.demail = demail;
	}
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Donation [donationid=" + donationid + ", demail=" + demail + ", ddate=" + ddate + ", paymentmode="
				+ paymentmode + ", amount=" + amount + "]";
	}
	
	


	
}
