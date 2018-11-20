package com.park.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.park.web.model.Customer;

//methods for adding new employee, will al employees, delete employee, update customer, get employee, validate employee.

public class CustomerDao {

	/////////////////////////////////////*Insert Customer*/////////////////////////////////////////////////

	// tested
	public static int saveCustomer(Customer CID) {
		int status = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con
					.prepareStatement("insert into customer(CID,Name,Phone,Address,Password) values(?,?,?,?,?)");

			ps.setInt(1, CID.getCID());
			ps.setString(2, CID.getName());
			ps.setInt(3, CID.getPhone());
			ps.setString(4, CID.getAddress());
			ps.setString(5, CID.getPassword());
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
	// tested
	public static int updateCustomer(Customer customer) {
		int status = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con
					.prepareStatement("update customer set CID=?,Name=?,Phone=?,Address=?,Password=? where CID=?");

			ps.setInt(1, customer.getCID());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getPhone());
			ps.setString(4, customer.getAddress());
			ps.setString(5, customer.getPassword());
			ps.setInt(6, customer.getCID());
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

	/////////////////////////////////////*Delete Customer by CID*/////////////////////////////////////////////////

	public static int deleteCustomer(int CID) {
		int status = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("delete from Customer where CID=?");

			ps.setInt(1, CID);

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

	/////////////////////////////////////*Get all values in Customer Table*/////////////////////////////////////////////////

	public Customer getCustomer(int CID)

	{

		Customer c = new Customer();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("select * from customer where CID= ? ");
			ps.setInt(1, CID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c.setCID(rs.getInt("CID"));
				c.setName(rs.getString("Name"));
				c.setPhone(rs.getInt("Phone"));
				c.setAddress(rs.getString("Address"));
				c.setPassword(rs.getString("Password"));
			}
			System.out.println(c);
		} catch (Exception e) {
			System.out.println(e);
		}

		return c;
	}

	public List<Customer> getAllCustomers() {
		List Custlist = new ArrayList();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("select * from customer");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer c = new Customer();
				c.setCID(rs.getInt("CID"));
				c.setName(rs.getString("Name"));
				c.setAddress(rs.getString("Address"));
				c.setPhone(rs.getInt("Phone"));
				c.setPassword(rs.getString("Password"));
				Custlist.add(c);
			}
			System.out.println("Added cust to List");
		} catch (Exception e) {
			System.out.println(e);
		}

		return Custlist;
	}

	public Customer isCustomer(int CID, String passwd) {
		Customer c = new Customer();

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("Select * from Customer where CID = ? and Password = ?");
			ps.setInt(1, CID);
			ps.setString(2, passwd);
			System.out.println("3");
			ResultSet rs = ps.executeQuery();	
			while (rs.next())
			{
				c.setCID(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getInt(3));
				c.setAddress(rs.getString(4));
				c.setPassword(rs.getString(5));

			}

			con.close();
			ps.close();
			rs.close();
			//System.out.println("Sending customer from dao object is  :"+c);
			return c;

		} 
		catch (Exception e) {
			System.out.println(e);
		}

		return c;

	}

	//	public static void main(String args[]) {
	//		//	  Customer cust = new Customer();
	//		//	  cust.setCID(4);
	//		//	  cust.setName("Rina");
	//		//	  cust.setAddress("OP");
	//		//	  cust.setPhone(1234);
	//		//	  cust.setPassword("park123");
	//		//	  
	//		CustomerDao obj = new CustomerDao();
	//		//	  List Li = obj.getAllCustomers();
	//		//	  Customer C1 = (Customer) Li.get(0);
	//		//	  System.out.println(C1.getCID() + C1.getName());
	//
	//		System.out.println(obj.isCustomer(1, "2728"));
	//
	//	}

}
