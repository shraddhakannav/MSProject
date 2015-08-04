package bookings;



public class WaitingState implements RequestState {

	private RequestInterface request;

	public WaitingState(RequestInterface request){
		this.request = request;
	}

	/*private int requestId;
	RequestState state;
	private String requestType;

	private String pickUpLocation;
	private String	destination;
	private int	FareEstimation;
	private Date bookingDate;
	private String CarType;
	 */
	@Override
	public String waitInQueue() {

		//		Queue<RequestInterface> queue = new LinkedList<RequestInterface>();
		//		queue.add(request);
		request.setState(new ProcessingState(request));
		return "Request placed in Queue";
	}

	@Override
	public String processRequest() {

		return "Request yet to be processed";
	}

	@Override
	public String completeRequest() {


		return "Request not processed yet";
	}


	@Override
	public String cancelRequest() {

		return "Cannot cancel: Request not booked yet";
	}





}
