package bookings;


public interface RequestState {
	public String waitInQueue();
	public String processRequest();
	public String completeRequest();
	public String cancelRequest();


}
