package dispatch;

public class Ride_ended  implements State{
	
	private Ride ride;
	public Ride_ended(Ride r)
	{
		ride=r;
	}
	public void startRide(){};
	public String modifyRide(String s){
		return "no";
	};
	public void cancelRide(){};
	public void delayRide(){};
	public void endRide(){
		
		System.out.println("");
		System.out.println("");
		System.out.println("Dear Customer your ride has ended. Thank you for using our service.");
		System.out.println("");
		System.out.println("Do you want to rate the Driver?");
		
	};

}
