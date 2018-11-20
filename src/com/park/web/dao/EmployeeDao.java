package com.park.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.park.web.model.Customer;
import com.park.web.model.Employee;
import com.park.web.model.Employee;

public class EmployeeDao {

/////////////////////////////////////*Insert Customer*/////////////////////////////////////////////////	

	public static int saveEmployee(Employee employee) {
		int status = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("insert into employee (EID,Name,Phone,Address,Role, password) values(?,?,?,?,?,?)");

			ps.setInt(1, employee.getEID());
			ps.setString(2, employee.getName());
			ps.setInt(3, employee.getPhone());
			ps.setString(4, employee.getAddress());
			ps.setString(5, employee.getRole());
			ps.setString(5, employee.getPassword());
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
	public static int updateEmployee(Employee employee) {
		int status = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("update bookings set EID=?,Name=?,Phone=?,Address=?,Role=?,password=? where EID=?");

			ps.setInt(1, employee.getEID());
			ps.setString(2, employee.getName());
			ps.setInt(3, employee.getPhone());
			ps.setString(4, employee.getAddress());
			ps.setString(5, employee.getRole());
			ps.setString(6, employee.getPassword());
			ps.setInt(7, employee.getEID());
			
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
	
	
/////////////////////////////////////*Delete Customer by BID*/////////////////////////////////////////////////

	public static int deleteEmployee(int EID) {
		int status = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("delete from Employee where EID=?");

			ps.setInt(1, EID);

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

	public Employee getEmployee(int EID)

	{

		Employee emp = new Employee();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("select * from customer where EID= ? ");
			ps.setInt(1, EID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp.setEID(rs.getInt("EID"));
				emp.setName(rs.getString("Name"));
				emp.setPhone(rs.getInt("Phone"));
				emp.setAddress(rs.getString("Address"));
				emp.setRole(rs.getString("Role"));
				emp.setPassword(rs.getString("password"));

			}
			System.out.println(emp);
		} catch (Exception e) {
			System.out.println(e);
		}

		return emp;
	}
	

///////////////////////////////////////Get List/////////////////////////////////////////////////////////////////////////////////
	
	public List<Employee> getAllEmployee()
	{
		List EmployeeList = new ArrayList();
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("select * from Employee");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			  Employee emp = new Employee();
			  emp.setEID(rs.getInt("EID"));
			  emp.setName(rs.getString("Name"));
			  emp.setPhone(rs.getInt("Phone"));
			  emp.setAddress(rs.getString("Address"));
			  emp.setRole(rs.getString("Role"));
			  emp.setPassword(rs.getString("password"));
			  EmployeeList.add(emp);
			}
			System.out.println("Added Bookings to List");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return EmployeeList;
	}
	
	
	public Employee isEmployee(int EID, String passwd) {
		Employee emp = new Employee();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "mysql");
			PreparedStatement ps = con.prepareStatement("Select * from Employee where EID = ? and Password = ?");
			ps.setInt(1, EID);
			ps.setString(2, passwd);
			ResultSet rs = ps.executeQuery();	
			while (rs.next())
			{
				emp.setEID(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setPhone(rs.getInt(3));
				emp.setAddress(rs.getString(4));
				emp.setRole(rs.getString(5));
				emp.setPassword(rs.getString(6));

			}
		//	System.out.println(c);
			con.close();
			ps.close();
			rs.close();
			return emp;
		} catch (Exception e) {
			System.out.println(e);
		}

		return emp;

	}


	
	
	
	
}
