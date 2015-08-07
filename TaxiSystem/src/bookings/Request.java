package bookings;

import java.util.Date;

public class Request implements RequestInterface {

	private int requestId;
	RequestState state;
	private String requestType;

	private String pickUpLocation;
	private String destination;

	private int pickX, pickY;
	private int destX, destY;

	private Date bookingDate;
	private String CarType;
	private int FareEstimation;
	private Bid bid;
	private boolean petFriendlyFlag;
	private boolean CarSeatFlag;

	@Override
	public boolean isPetFriendlyFlag() {
		return petFriendlyFlag;
	}

	@Override
	public void setPetFriendlyFlag(boolean petFriendlyFlag) {
		this.petFriendlyFlag = petFriendlyFlag;
	}

	public int getPickX() {
		return pickX;
	}

	public void setPickX(int pickX) {
		this.pickX = pickX;
	}

	public int getPickY() {
		return pickY;
	}

	public void setPickY(int pickY) {
		this.pickY = pickY;
	}

	public int getDestX() {
		return destX;
	}

	public void setDestX(int destX) {
		this.destX = destX;
	}

	public int getDestY() {
		return destY;
	}

	public void setDestY(int destY) {
		this.destY = destY;
	}

	@Override
	public boolean isCarSeatFlag() {
		return CarSeatFlag;
	}

	@Override
	public void setCarSeatFlag(boolean carSeatFlag) {
		CarSeatFlag = carSeatFlag;
	}

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public Request() {

	}

	public Request(String requestType, String pickUplocation,
			String destination, Date bookingDate, String CarType, Bid bid) {
		this.requestType = requestType;
		this.pickUpLocation = pickUplocation;
		this.destination = destination;
		this.bookingDate = bookingDate;
		this.CarType = CarType;
		this.bid = bid;
		state = new WaitingState(this);
	}

	@Override
	public void waitInQueue() {

		System.out.println(state.waitInQueue());
	}

	@Override
	public void processRequest() {
		System.out.println(state.processRequest());

	}

	@Override
	public void completeRequest() {
		System.out.println(state.completeRequest());

	}

	@Override
	public void cancelRequest() {
		// TODO Auto-generated method stub

	}

	@Override
	public RequestState getState() {
		return state;
	}

	@Override
	public void setState(RequestState state) {
		this.state = state;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getFareEstimation() {
		return FareEstimation;
	}

	public void setFareEstimation(int fareEstimation) {
		FareEstimation = fareEstimation;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getCarType() {
		return CarType;
	}

	public void setCarType(String carType) {
		CarType = carType;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Request:");
		sb.append("\n___________________________________");
		sb.append("\nType of request: " + requestType);
		sb.append("\nPickup Location: " + pickUpLocation + " [" + pickX + ","
				+ pickY + "]");
		sb.append("\nDestination: " + destination + " [" + destX + "," + destY
				+ "]");
		sb.append("\nBooking Date: " + bookingDate);
		sb.append("\nCar Type: " + CarType);
		sb.append("\nPet Friendly: " + petFriendlyFlag);
		sb.append("\nCar Seat: " + CarSeatFlag);
		if (bid != null)
			sb.append("\nBidding Fare: " + bid.getFare());

		String string = sb.toString();

		return string;
	}
}
