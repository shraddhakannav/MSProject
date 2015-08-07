package bookings;

public class Bid extends Fare {

	private Request request;
	private double fare;

	public Bid() {
		// TODO Auto-generated constructor stub
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public void postBid(double bid) {
		if (request != null)
			notifyObservers("Next bid for request: " + request.toString()
					+ " is $" + fare);
		System.out.println("I am ok with the bid"); // Driver, request
	}
}
