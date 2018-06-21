package com.maveric.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.maveric.Model.FlightModel;

public class DatabaseDetails 
{
  static final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sruthi";
  
  static final String USER = "flight";
  static final String PASS = "flight";
  
  public int addFlightToDB(FlightModel flightmodel) throws SQLException
  {
	  //boolean blon = false;
	  int i = 0;
	  Connection conn = null;
	  Statement stmt = null;
	  
	  try
	  {
		  //registering the Driver here
		  Class.forName(JDBC_DRIVER);
		  
		  //getting the connection
		  conn=DriverManager.getConnection(DB_URL, USER, PASS);
		  
		  //creating the statement
		  stmt=conn.createStatement();
		  
		  String query = "INSERT INTO flightdetails (FlightName, Source, Destination, Noofseats,Aircraft) values('"+flightmodel.getFlightname()+"','"+flightmodel.getSource()+"','"+flightmodel.getDestination()+"','"+flightmodel.getNoofseats()+"','"+flightmodel.getAircraft()+"')";
		  i = stmt.executeUpdate(query);
		  
		  /*if(result>0)
		  {
			  blon = true;
		  }
		  
		  else
		  {
			  blon = false;
		  }*/
	  }
	  catch (Exception e)
	  {
		  System.out.println(e.getMessage());
	  }
	  finally
	  {
		 stmt.close();
		 conn.close();
	  }
	return i;
  }
}
