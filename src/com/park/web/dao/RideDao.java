package com.park.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.park.web.model.Ride;

public class RideDao {

/////////////////////////////////////*Insert Customer*/////////////////////////////////////////////////	

	public static int saveRide(Ride ride) {
		int status = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "2727");
			PreparedStatement ps = con.prepareStatement("insert into employee (RID,Name,Maintainance) values(?,?,?)");

			ps.setInt(1, ride.getRID());
			ps.setString(2, ride.getName());
			ps.setDate(3, ride.getMaintainance());
			
			status = ps.executeUpdate();
			if (status == 1) {
				System.out.println("Saved Succesful ");
			} else {
				System.out.println("Not saved succesful ");
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

/////////////////////////////////////*Update Customer*/////////////////////////////////////////////////
//tested
	public static int updateRide(Ride ride) {
		int status = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "2727");
			PreparedStatement ps = con.prepareStatement(
					"update bookings set RID=?,Name=?,Maintainance=? where RID=?");

			ps.setInt(1, ride.getRID());
			ps.setString(2, ride.getName());
			ps.setDate(3, ride.getMaintainance());
			ps.setInt(4, ride.getRID());

			status = ps.executeUpdate();
			if (status == 1) {
				System.out.println("Successfull Update");
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

/////////////////////////////////////*Delete Ride by RID*/////////////////////////////////////////////////

	public static int deleteRide(int RID) {
		int status = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "2727");
			PreparedStatement ps = con.prepareStatement("delete from Ride where RID=?");

			ps.setInt(1, RID);

			status = ps.executeUpdate();
			if (status == 1) {
				System.out.println("Deleted successfully");
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

/////////////////////////////////////*Get all values in Rides Table*/////////////////////////////////////////////////

	public Ride getRide(int RID)

	{

		Ride rid = new Ride();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "2727");
			PreparedStatement ps = con.prepareStatement("select * from ride where RID= ? ");
			ps.setInt(1, RID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rid.setRID(rs.getInt("RID"));
				rid.setName(rs.getString("Name"));
				rid.setMaintainance(rs.getDate("Maintainance"));
				

			}
			System.out.println(rid);
		} catch (Exception e) {
			System.out.println(e);
		}

		return rid;
	}

	
	public List<Ride> getAllRide()
	{
		List RideList = new ArrayList();
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "2727");
			PreparedStatement ps = con.prepareStatement("select * from Employee");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			  Ride rid = new Ride();
			  rid.setRID(rs.getInt("EID"));
			  rid.setName(rs.getString("Name"));
			  rid.setMaintainance(rs.getDate("Maintainance"));
			  
			  RideList.add(rid);
			}
			System.out.println("Added Bookings to List");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return RideList;
	}
}