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
import com.park.web.model.Bookings;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("cid");
		BookingsDao bdao = new BookingsDao();
		List<Bookings> blist = bdao.getBookings(id);
		if(blist.isEmpty())
		{
			String msg = "No upcoming tickets";
			System.out.println(msg);
			request.setAttribute("var2",msg);
		
		}
		else
		{
			System.out.println("list of bookings : "+ blist);
			request.setAttribute("blist",blist);
				
		}
		
		request.getRequestDispatcher("Home.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
