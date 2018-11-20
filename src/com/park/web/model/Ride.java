package com.park.web.model;
import java.sql.Date;

public class Ride {

	private int RID; 
	private	String Name;
	private Date Maintainance;
	public int getRID() {
		return RID;
	}
	public void setRID(int rID) {
		RID = rID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getMaintainance() {
		return Maintainance;
	}
	public void setMaintainance(Date maintainance) {
		Maintainance = maintainance;
	}
	@Override
	public String toString() {
		return "Ride [RID=" + RID + ", Name=" + Name + ", Maintainance=" + Maintainance + "]";
	}
	
	
}
