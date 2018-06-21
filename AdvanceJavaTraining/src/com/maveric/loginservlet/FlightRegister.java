package com.maveric.loginservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maveric.DAO.DatabaseDetails;
import com.maveric.Model.FlightModel;
import com.maveric.Model.FlightService;

/**
 * Servlet implementation class FlightRegister
 */
//@WebServlet("/FlightRegister")
public class FlightRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightRegister() {
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
		//doGet(request, response);
		
		String FlightName=request.getParameter("Flightname");
		String Source=request.getParameter("Srce");
		String Destination=request.getParameter("Dstn");
		int Noofseats=Integer.parseInt(request.getParameter("No of seats"));
		String Aircraftname =request.getParameter("Aircraft name");
		
		System.out.println("Flight Detail is:" + FlightName + Source + Destination + Noofseats + Aircraftname );
	
		FlightModel fmodel = new FlightModel();
		fmodel.setFlightname(FlightName);
		fmodel.setSource(Source);
		fmodel.setDestination(Destination);
		fmodel.setNoofseats(Noofseats);
		fmodel.setAircraft(Aircraftname);
		
		FlightService FS = new FlightService();
		boolean bln = FS.FlightService(fmodel);
		
		if (bln)
		{
			DatabaseDetails dbd = new DatabaseDetails();
			//boolean bln1 = dbd.addFlightToDB(fmodel);
			int flight = 0;
			try {
				flight = dbd.addFlightToDB(fmodel);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (flight>0)
			{
				RequestDispatcher RD = request.getRequestDispatcher("Redirect.jsp");
				RD.forward(request,response);
		        System.out.println("It is added to DB");
			}
			else
			{
				System.out.println("It is not added to DB");
			}
		}
		else
		{
			response.sendRedirect("http://www.makemytrip.com");
		}
	}

}
