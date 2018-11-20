package com.park.web.model;

public class Customer {

	private	int CID;
	private	String Name;
	private	int Phone;
	private	String Address;
	private String Password;
	
	
	public int getCID() {
		return CID;
	}
	public void setCID(int cID) {
		CID = cID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "Customer [CID=" + CID + ", Name=" + Name + ", Phone=" + Phone + ", Address=" + Address + ", Password="
				+ Password + "]";
	}
	

	
	
	
}
