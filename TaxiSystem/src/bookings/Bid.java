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
		if (getRequest() != null)
			notifyObservers("Next bid for request: " + getRequest().toString()
					+ " is $" + fare);
	}

	public void postBid(double bid) {
		System.out.println("I am ok with the bid"); // Driver, request
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
