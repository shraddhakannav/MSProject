package dispatch;

public class Ride_Delayed implements State{
	
	private Ride ride;
	public Ride_Delayed(Ride r)
	{
		ride=r;
	}
	public void startRide(){};
	public String modifyRide(String s){
		return "no";
	};
	public void cancelRide(){};
	
	public void delayRide(){
		System.out.println("Dear Customer your ride will be delayed by 1 minute");
		
		try {
			Thread.sleep(3600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ride.setState(new Ride_Modified(ride));
		System.out.println("Dear Customer your 1 minute is over");
	};
	public void endRide(){};

}
