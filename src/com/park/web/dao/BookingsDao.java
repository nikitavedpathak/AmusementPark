package com.park.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.park.web.model.Bookings;
import com.park.web.model.Customer;

public class BookingsDao {

	/////////////////////////////////////*Insert Customer*/////////////////////////////////////////////////	

	public static int saveBookings(Bookings bookings) {
		int status = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement(
					"insert into bookings (cid,bookingdate,paymenttype,nooftickets,totalcost,paymentflag) values(?,?,?,?,?,?)");
			ps.setInt(1, bookings.getCid());
			ps.setString(2, bookings.getBookingdate().toString());
			ps.setString(3, bookings.getPaymenttype());
			ps.setInt(4, bookings.getNooftickets());
			ps.setInt(5, bookings.getTotalcost());
			ps.setBoolean(6, bookings.isPaymentflag());


			status = ps.executeUpdate();

			if (status == 1) {
				System.out.println("Saved Succesful ");
			} else {
				System.out.println("Not saved succesful ");
			}
			con.close();
			ps.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}


	public List<Bookings> getBookings(int cid)
	{
		List<Bookings> bookinglist = new ArrayList<Bookings>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("select * from bookings where cid=? and bookingdate > date(sysdate())");
			ps.setInt(1,cid);
			System.out.println(cid);
			ResultSet rs = ps.executeQuery();


			while(rs.next())
			{
				Bookings b = new Bookings();
				b.setBid(rs.getInt(1));
				b.setCid(rs.getInt(2));
				b.setBookingdate(rs.getString(3));
				b.setPaymenttype(rs.getString(4));
				b.setNooftickets(rs.getInt(5));
				b.setTotalcost(rs.getInt(6));
				b.setPaymentflag(rs.getBoolean(7));

				bookinglist.add(b);

			}	
			con.close();
			ps.close();
			rs.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return bookinglist;
	}


	public Bookings getRecord(int bid)
	{
		Bookings b = new Bookings();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("select * from bookings where bid=?");
			ps.setInt(1, bid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				b.setBid(rs.getInt("bid"));
				b.setCid(rs.getInt("cid"));
				b.setBookingdate(rs.getString("bookingdate"));
				b.setPaymenttype(rs.getString("paymenttype"));
				b.setNooftickets(rs.getInt("nooftickets"));
				b.setTotalcost(rs.getInt("totalcost"));
				b.setPaymentflag(rs.getBoolean("paymentflag"));
			}

			con.close();
			ps.close();
			rs.close();

		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		return b;

	}

	public int editBookings(Bookings b)
	{
		int i =10;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("update bookings set bookingdate=?,paymenttype=?,nooftickets=?,totalcost=? where bid=?");
			ps.setString(1,b.getBookingdate());
			ps.setString(2, b.getPaymenttype());
			ps.setInt(3, b.getNooftickets());
			ps.setInt(4, b.getTotalcost());
			ps.setInt(5, b.getBid());

			i = ps.executeUpdate();
			if(i==1)
			{
				System.out.println("Bookind edited successfully");
			}
			else
			{
				System.out.println("Error updating bookings");
			}		

			con.close();
			ps.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}

	public int cancelBooking(int bid)
	{
		int i =10;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("delete from bookings where bid=?");
			ps.setInt(1,bid);

			i = ps.executeUpdate();
			if(i==1)
			{
				System.out.println("Bookind edited successfully");
			}
			else
			{
				System.out.println("Error updating bookings");
			}		

			con.close();
			ps.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return i;


	}


	//		public static void main(String args[])
	//		{
	//			BookingsDao b = new BookingsDao();
	//			Bookings obj = b.getRecord(10);
	//			System.out.println(obj.getBid()+", "+ obj.getCid()+" ,"+obj.getBookingdate()+", "+obj.getPaymenttype());
	//		}





}