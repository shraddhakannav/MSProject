package bookings;


public interface RequestInterface {


	public void waitInQueue();
	public void cancelRequest();
	public void processRequest();
	public void completeRequest();
	public RequestState getState();
	public void setState(RequestState s);

	public boolean isPetFriendlyFlag() ;
	public void setPetFriendlyFlag(boolean petFriendlyFlag);
	public boolean isCarSeatFlag();
	public void setCarSeatFlag(boolean carSeatFlag);


	//double pickuplat, double pickupLong, double destLat, double destLong, Date time, String carType);
}
