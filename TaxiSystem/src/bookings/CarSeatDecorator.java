package bookings;

public class CarSeatDecorator extends RequestDecorator {

	public CarSeatDecorator(RequestInterface request) {
		// TODO Auto-generated constructor stub
		super(request);
	}

	public void addCarSeat() {
		request.setCarSeatFlag(true);

	}
}
