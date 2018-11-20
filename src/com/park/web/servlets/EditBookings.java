package com.park.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.park.web.dao.BookingsDao;
import com.park.web.model.Bookings;

/**
 * Servlet implementation class EditBookings
 */
@WebServlet("/EditBookings")
public class EditBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("bid"));
		BookingsDao bd = new BookingsDao();
		Bookings bobj = bd.getRecord(id);
		request.setAttribute("bobj", bobj);
		request.getRequestDispatcher("EditBookings.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("inside do post of editbookings");
		int id = Integer.parseInt(request.getParameter("bid"));
		String type= request.getParameter("requesttype");
		System.out.println(id+type);
		BookingsDao bd = new BookingsDao();
		String msg;
		if(type.equals("cancel"))
		{
			System.out.println("got request type as cancel");
			int i = bd.cancelBooking(id);
			if(i==1)
			{
				msg = "Booking is Cancelled";
			}
			else
			{
				msg = "Error in cancelling Booking";
			}			
		}
		else
		{
			

			Bookings b = new Bookings();
			b.setBid(Integer.parseInt(request.getParameter("bid")));
			b.setCid(Integer.parseInt(request.getParameter("custid")));
			b.setBookingdate(request.getParameter("bdate"));
			b.setNooftickets(Integer.parseInt(request.getParameter("nooftickets")));
			b.setTotalcost(Integer.parseInt(request.getParameter("totalcost")));
			b.setPaymenttype( request.getParameter("paymenttype"));
			b.setPaymentflag(true);
			int i =bd.editBookings(b);
			if(i==1)
			{
				 msg = "Bookings details updated successfully";
			}		
			else
			{
			   msg = "Error updating booking details";	
			}
			
		}
			
		request.setAttribute("updatestatus", msg);
		request.getRequestDispatcher("EditBookings.jsp").forward(request, response);
	}

}
