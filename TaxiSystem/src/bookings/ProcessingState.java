package bookings;



public class ProcessingState implements RequestState{

	private RequestInterface request;
	public ProcessingState(RequestInterface request) {
		this.request = request;
	}

	@Override
	public String waitInQueue() {
		// TODO Auto-generated method stub
		return "Request already placed in queue";
	}



	@Override
	public String processRequest() {
		// Add this to the main program
		//
		IDispatcher dispatch = new Dispatcher();
		Ride ride = dispatch.dispatchRequest();
		if(ride!=null){
			request.setState(new BookedState(request));
			return "Booking successful";
		}
		else{

			return "Booking failed, Please try again";
		}
	}

	@Override
	public String completeRequest() {
		// TODO Auto-generated method stub
		return "Request not processed yet";
	}

	@Override
	public String cancelRequest(){

		return null;
	}




}
