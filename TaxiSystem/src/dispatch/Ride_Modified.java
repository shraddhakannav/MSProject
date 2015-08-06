package dispatch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ride_Modified implements State{
	
	private Ride ride;
	public Ride_Modified(Ride r)
	{
		ride=r;
	}
	public void startRide(){};
	public String modifyRide( String s){
		
		
		try{
			
//		System.out.println("");
//		System.out.println("");
//		System.out.println("Ride is in process..");
//		System.out.println("Do you want to cancel/delay Ride? [cancel/delay/no]");
//		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
//        String s = bufferRead.readLine();
        if(s.equalsIgnoreCase("4"))
        {
        	System.out.println("Ride is cancelled");
        	ride.setState(new Ride_Cancelled(ride));
        }
        	
        
        else
        {
        	System.out.println("Driver ended Ride. Make  Payment");
        	ride.setState(new Ride_ended(ride));
        }
        
        return s;
		}
		catch(Exception e)
		{e.printStackTrace();}
		
		return "";
		
	}
	public void cancelRide(){
		System.out.println("Ride in process..");
	};
	public void delayRide(){
		System.out.println("Ride in process..");
	};
	public void endRide(){
		System.out.println("Ride in process..");
	};

}
