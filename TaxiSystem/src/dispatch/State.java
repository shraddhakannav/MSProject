package dispatch;

public interface State {
	public void startRide();
	public String modifyRide(String s);
	public void cancelRide();
	public void delayRide();
	public void endRide();

}
