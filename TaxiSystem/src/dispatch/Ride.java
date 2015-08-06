package dispatch;

public interface Ride {
	
	
	public void startRide();
	public String modifyRide(String s);
	public void cancelRide();
	public void delayRide();
	public void endRide();
	public void setState(State s);
	public State getState();

}
