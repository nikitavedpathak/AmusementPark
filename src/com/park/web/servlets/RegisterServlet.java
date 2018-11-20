package com.park.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.park.web.dao.CustomerDao;
import com.park.web.model.Customer;

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("cid"));
		String cname = request.getParameter("name");
		int cphone = Integer.parseInt(request.getParameter("phoneno"));
		String caddress = request.getParameter("address");
		String cpass = request.getParameter("pwd");
		
		System.out.println(id + cname + cphone+ caddress + cpass);
		
		Customer newcust = new Customer();
		newcust.setCID(id);
		newcust.setName(cname);
		newcust.setPhone(cphone);
		newcust.setAddress(caddress);
		newcust.setPassword(cpass);
		
		CustomerDao cdao = new CustomerDao();
		int i = cdao.saveCustomer(newcust);
		System.out.println(i);
		String msg ; 
		if(i==1)
		{
			 msg = "Registered Successfully";
		}
		else
		{
			 msg = "Error in Registering new user";
		}
		request.setAttribute("var",msg);
		request.getRequestDispatcher("Register.jsp").forward(request, response);
		
	}

}
