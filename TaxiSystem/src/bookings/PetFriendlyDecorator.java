package bookings;

public class PetFriendlyDecorator extends RequestDecorator {
	public PetFriendlyDecorator(RequestInterface request) {
		// TODO Auto-generated constructor stub
		super(request);
	}

	public void makePetFriendly() {
		// TODO Auto-generated method stub

		request.setPetFriendlyFlag(true);
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
	
		
	}

	@Override
	public boolean isCarSeatFlag() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCarSeatFlag(boolean carSeatFlag) {
		// TODO Auto-generated method stub
		
	}

}
