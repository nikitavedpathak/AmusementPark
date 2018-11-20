package com.park.web.model;

public class Employee {

	private  int EID;
	private	 String Name;
	private  int Phone;
	private  String Address;
	private	 String Role;
	private	 String Password;
	
	
	
	
	
	public int getEID() {
		return EID;
	}
	public void setEID(int eID) {
		EID = eID;
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
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "Employee [EID=" + EID + ", Name=" + Name + ", Phone=" + Phone + ", Address=" + Address + ", Role="
				+ Role + ", Password=" + Password + "]";
	}
	
	
	
	
	
	
	
	
	
}
