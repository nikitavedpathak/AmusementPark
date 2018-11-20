package com.park.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.park.web.dao.BookingsDao;
import com.park.web.dao.CustomerDao;
import com.park.web.dao.EmployeeDao;
import com.park.web.model.Bookings;
import com.park.web.model.Customer;
import com.park.web.model.Employee;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String id1=request.getParameter("uname");
		int id = Integer.parseInt(id1);
		String password=request.getParameter("password");
		System.out.println(id + password);
		CustomerDao cust1 = new CustomerDao();
		Customer c = cust1.isCustomer(id, password);
		System.out.println(c);
		String msg;
		if(c.getCID() != 0)
		{			
			System.out.println("Valid Credentials");
			HttpSession session = request.getSession();			
			session.setAttribute("cname", c.getName());	
			session.setAttribute("cid", c.getCID());
			request.getRequestDispatcher("HomeServlet").forward(request,response);
						
		}
		else {
			System.out.println("Check login Details");
			msg = "Please Check Login details";
			request.setAttribute("var",msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

	}

}
