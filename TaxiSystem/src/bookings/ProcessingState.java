package bookings;

import dispatch.Dispatcher;



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
		
		Dispatcher dispatch = new Dispatcher();
		Request newreq = (Request)request;
		try{
			dispatch.dispatchRequest(newreq);
		
			request.setState(new BookedState(request));
			return "Booking successful";
		}
		
		catch(Exception e){

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
	public String toString(){
		return "Processing";
	}



}
