package com.park.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.park.web.dao.CustomerDao;
import com.park.web.model.Customer;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Inside account do get method");
		HttpSession session = request.getSession();
		int cid = (int) session.getAttribute("cid");
		System.out.println("got cid as:"+cid);
		CustomerDao cd = new CustomerDao();
	    Customer c = cd.getCustomer(cid);
	    System.out.println("Got custoer object as:"+ c.getCID()+c.getName());
	    request.setAttribute("cobj", c);
	    request.getRequestDispatcher("Account.jsp").forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String requesttpe= request.getParameter("");
		
		
		
		
		
		
	}

}
