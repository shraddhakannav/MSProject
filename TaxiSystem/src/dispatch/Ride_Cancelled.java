package dispatch;

public class Ride_Cancelled implements State{
	
	private Ride ride;
	public Ride_Cancelled(Ride r)
	{
		ride=r;
	}
	public void startRide(){};
	public String modifyRide(String s){
		return "no";
	};
	public void cancelRide(){
		System.out.println("Dear Customer you have cancelled your ride. ");
		ride.setState(new Ride_ended(ride));
	};
	public void delayRide(){};
	public void endRide(){};

}
