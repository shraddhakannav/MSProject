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

}
