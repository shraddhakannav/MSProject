package bookings;

public class BookedState implements RequestState{

	private RequestInterface request;
	public BookedState(RequestInterface request)
	{
		this.request = request;
	}
	@Override
	public String waitInQueue() {
		// TODO Auto-generated method stub
		return "Request already in queue";
	}

	@Override
	public String cancelRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processRequest() {
		// TODO Auto-generated method stub
		return "Request already processed";
	}


	@Override
	public String completeRequest() {
		// TODO Auto-generated method stub
	//request.setState(new WaitingState(request));
	//	new DataAccess().insertRequest(request, customerId);
				
		return "Request completed successfully";
	}
	
	public String toString(){
		return "Booked";
	}
}
