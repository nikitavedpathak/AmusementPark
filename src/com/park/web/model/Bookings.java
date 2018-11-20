package com.park.web.model;
import java.sql.Date;

public class Bookings {

	private int bid;
	private	int cid;
	private String bookingdate;
	private	String paymenttype;
	private	int nooftickets;
	private int totalcost;
	private boolean paymentflag;
	
		
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public int getNooftickets() {
		return nooftickets;
	}
	public void setNooftickets(int nooftickets) {
		this.nooftickets = nooftickets;
	}
	public int getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}
	public boolean isPaymentflag() {
		return paymentflag;
	}
	public void setPaymentflag(boolean paymentflag) {
		this.paymentflag = paymentflag;
	}
	
	
	
}
