package dispatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import bookings.Request;

public class Dispatcher  implements DispatcherInterface{
	
	public void dispatchRequest(Request request)
//	public static void main(String arg[]) 
	{
		try{
			
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		ArrayList confirmedDriver=new ArrayList(); 
		String status="delay";
		String command="-1";
	
		// ************   BRIDGE PATTERN *************//
		Vehicle v1;
		Algorithm algorithm;
		ArrayList pass_argument=new ArrayList();
		algorithm=new Algorithm1();
		v1=new InstantCab(algorithm);
		ArrayList result=v1.callAlgorithm(pass_argument);
		//System.out.println("result  "+result);
		
		// ************   BRIDGE PATTERN ENDS *************//
		
		for(int i=0;i<result.size();i++)
		{
			ArrayList temp=(ArrayList)result.get(i);
			
			System.out.println("");
			System.out.println("");
			System.out.println("Driver No "+temp.get(2)+" do you want to accept this Ride? [Y/N]");
			
			
			
			
			System.out.println("");
	        String s = bufferRead.readLine();
	        if(s.equalsIgnoreCase("Y"))
	        {
	        	confirmedDriver=temp;
	        	i=result.size();
	        	System.out.println("");
	    		System.out.println("");
	    		System.out.println("Dear Customer your ride is confirmed. Driver no "+temp.get(2)+" will come to pick you");
	    		
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
