package bookings;

public abstract class RequestDecorator {

	protected RequestInterface request;
	public RequestDecorator(RequestInterface request){
		this.request = request;
	}


}