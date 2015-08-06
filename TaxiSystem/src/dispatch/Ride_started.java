package dispatch;

public class Ride_started implements State{
	
	private Ride ride;
	public Ride_started(Ride r)
	{
		ride=r;
	}
	public void startRide(){
		System.out.println("");
		System.out.println("");
		System.out.println("Ride Started");
		ride.setState(new Ride_Modified(ride));
		//System.out.println("check  "+ride.getState());
	};
	public String modifyRide(String s){
		System.out.println("Ride Started..");
		return "";
	};
	public void cancelRide(){
		System.out.println("Ride Started..");
	};
	public void delayRide(){
		System.out.println("Ride Started..");
	};
	public void endRide(){
		System.out.println("Ride Started..");
	};

}
