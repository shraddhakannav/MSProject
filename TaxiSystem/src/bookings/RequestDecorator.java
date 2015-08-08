package bookings;

public abstract class RequestDecorator implements RequestInterface {

	protected RequestInterface request;
	
	public RequestDecorator(RequestInterface request){
		this.request = request;
	}


}