package com.Sharecare.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int addressId;
	String  houseNo;
	String landmark;
	String city;
	String state;
	int pincode;
	int id;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int addressId, String houseNo, String landmark, String city, String state, int pincode, int id) {
		super();
		this.addressId = addressId;
		this.houseNo = houseNo;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.id = id;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseNo=" + houseNo + ", landmark=" + landmark + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + ", id=" + id + "]";
	}
	
	
}
