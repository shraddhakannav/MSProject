package dispatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import members.Driver;
import bookings.DataAccess;
import bookings.Request;

public class Dispatcher  implements DispatcherInterface{
	
	public void dispatchRequest(Request request)
//	public static void main(String arg[]) 
	{
		try{
			
			// Request request=new Request();
			// request.setPickX(0);
			// request.setPickY(0);
			// request.setDestX(0);
			// request.setDestY(0);		
			
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		DataAccess dataAccess=new DataAccess();
		Driver confirmedDriver=new Driver(); 
		String status="delay";
		String command="-1";
	
		// ************   BRIDGE PATTERN *************//
		Vehicle v1;
		Algorithm algorithm;
		ArrayList driver_list=dataAccess.retreiveDriverByStatus("available");
		ArrayList pass_argument=new ArrayList();
		pass_argument.add(request);
		pass_argument.add(driver_list);
		algorithm=new Algorithm1();
		v1=new InstantCab(algorithm);
		ArrayList result=v1.callAlgorithm(pass_argument);
		//System.out.println("result  "+result);
		
		// ************   BRIDGE PATTERN ENDS *************//
		
		for(int i=0;i<result.size();i++)
		{
			Driver temp=(Driver)result.get(i);
			
			System.out.println("");
			System.out.println("");
			System.out.println("Driver No "+ temp.getDistance()+" do you want to accept this Ride? [Y/N]");
			
			
			
			
			System.out.println("");
	        String s = bufferRead.readLine();
	        if(s.equalsIgnoreCase("Y"))
	        {
	        	confirmedDriver=temp;
	        	i=result.size();
	        	System.out.println(temp.getName());
	    		System.out.println(confirmedDriver.getName());
	    		vehicles.Vehicle vehicle=dataAccess.retreiveVehicleByDriver(confirmedDriver.getName());
	    		System.out.println("");
	    		System.out.println("Dear Customer your ride is confirmed. These are the details : :");
	    		System.out.println("Dear Customer your ride is confirmed. These are the details : :");
	    		
	        }
	       
		}    /// drivers confirmed
		
		RideClass rideClass=new RideClass();
		rideClass.setDriver_id(1);
		boolean is_start=false;
		
		
		do
		{
			System.out.println("");
			
    		System.out.println("*****For Driver*******");
    		System.out.println(" 1 : Start Ride");
    		System.out.println(" 2 : End Ride");
    		System.out.println(" 3 : Delay Ride");
    		System.out.println("");
    		System.out.println("******For User******");
    		System.out.println(" 4 : Cancel Ride");
    		
    		String s = bufferRead.readLine();
    		command=s;
    		if(s.equals("1") && !is_start)
    		{
    			is_start=true;
    			rideClass.startRide();
    		}
    		else if(s.equals("1") && is_start)
    		{
    			System.out.println("Ride is already started.");
    		}
    		
    		else if(s.equals("2") && !is_start)
    		{
    			System.out.println("Ride is not even started.");
    			command="-1";
    		}
    		else if(s.equals("3") && !is_start)
    		{
    			System.out.println("Dear Customer your ride will be delayed by some minute");
    		}
    		else if(s.equals("3") && is_start)
    		{
    			System.out.println("Ride is already started. Cant delay it. Invalid selection");
    		}
    		else
    		{
    			rideClass.modifyRide(s);
    			command="-2";
    		}
		}
		while(!command.equals("-2"));
		
		
		
		
//		while(status.equalsIgnoreCase("delay"))
//		{
//		status=rideClass.modifyRide();
//		if(status.equalsIgnoreCase("delay"))
//		rideClass.delayRide();
//		}
//		
//		 if(status.equalsIgnoreCase("cancel"))
//		{
//		rideClass.cancelRide();
//		}
//		else
//			rideClass.endRide();
		
		
	}
		catch(Exception e)
		{e.printStackTrace();}
	}

}
