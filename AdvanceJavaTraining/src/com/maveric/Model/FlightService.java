package com.maveric.Model;

public class FlightService 
{
    public boolean FlightService(FlightModel model)
    {
    	boolean name;
    	if (model.getAircraft().equals("boeing"))
    	{
    		name = true;
    	}
    	else
    	{
    	 name = false;	
    	}
		return name;
    }
}
