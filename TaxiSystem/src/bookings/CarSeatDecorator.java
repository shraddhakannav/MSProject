package bookings;

public class CarSeatDecorator extends RequestDecorator {

	public CarSeatDecorator(RequestInterface request) {
		// TODO Auto-generated constructor stub
		super(request);
	}

	public void addCarSeat() {
		
		request.setCarSeatFlag(true);

	}

	@Override
	public void waitInQueue() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void completeRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RequestState getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setState(RequestState s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPetFriendlyFlag() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPetFriendlyFlag(boolean petFriendlyFlag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCarSeatFlag() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCarSeatFlag(boolean carSeatFlag) {
		request.setCarSeatFlag(true);

		
	}
}
