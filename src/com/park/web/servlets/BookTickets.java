package com.park.web.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;

import com.park.web.dao.BookingsDao;
import com.park.web.model.Bookings;

/**
 * Servlet implementation class BookTickets
 */
@WebServlet("/booktickets")
public class BookTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTickets() {
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
		
		int id = Integer.parseInt(request.getParameter("custid"));		
		String d = request.getParameter("bdate");		
		int ticketcount = Integer.parseInt(request.getParameter("nooftickets"));		
		int totalamt = Integer.parseInt(request.getParameter("totalcost"));
		String paytype = request.getParameter("paymenttype");
		
		System.out.println("Got all details: "+ id+d+ticketcount+totalamt+paytype);
		Bookings b = new Bookings();
		b.setCid(Integer.parseInt(request.getParameter("custid")));
		b.setBookingdate(request.getParameter("bdate"));
		b.setNooftickets(Integer.parseInt(request.getParameter("nooftickets")));
		b.setTotalcost(Integer.parseInt(request.getParameter("totalcost")));
		b.setPaymenttype( request.getParameter("paymenttype"));
		b.setPaymentflag(true);
		
		BookingsDao bd = new BookingsDao();
		int i = bd.saveBookings(b);
		if(i==1)
		{
			String msg = "Tickets are Booked";
			request.setAttribute("var1",msg);
			request.getRequestDispatcher("BookTicket.jsp").forward(request, response);
		}
		else
		{
			String msg = "Error in Booking";
			request.setAttribute("var1",msg);
			request.getRequestDispatcher("BookTicket.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
	}

}
