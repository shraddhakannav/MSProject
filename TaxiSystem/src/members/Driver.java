package members;

import java.util.ArrayList;

import bookings.Fare;

public class Driver extends Member {

	String licenceNo;
	String registrationDate;
	ArrayList<String> shiftDays;
	String shiftStartTime;
	String shiftEndTime;
	private boolean isObserver;
	private int distance;
	private int current_longitude;
	private int current_latitude;

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String d) {
		this.licenceNo = d;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public ArrayList<String> getShiftDays() {
		return shiftDays;
	}

	public void setShiftDays(ArrayList<String> shiftDays) {
		this.shiftDays = shiftDays;
	}

	public String getShiftStartTime() {
		return shiftStartTime;
	}

	public void setShiftStartTime(String shiftStartTime) {
		this.shiftStartTime = shiftStartTime;
	}

	public String getShiftEndTime() {
		return shiftEndTime;
	}

	public void setShiftEndTime(String shiftEndTime) {
		this.shiftEndTime = shiftEndTime;
	}

	@Override
	public String toString() {

		String string = this.getName();

		String driverStr = "Registartion Date: " + this.getRegistrationDate();

		return string + ": " + driverStr;
	}

	// Observer Pattern for bidding
	@Override
	public void update(Fare fare, String message) {
		System.out.println("Notified Driver: " + this.getName());
		if (message != null && !message.isEmpty()) {
			System.out.println("The message is: " + message);
		}

	}

	public boolean isObserver() {
		return isObserver;
	}

	public void setObserver(boolean isObserver) {
		this.isObserver = isObserver;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getCurrent_longitude() {
		return current_longitude;
	}

	public void setCurrent_longitude(int current_longitude) {
		this.current_longitude = current_longitude;
	}

	public int getCurrent_latitude() {
		return current_latitude;
	}

	public void setCurrent_latitude(int current_latitude) {
		this.current_latitude = current_latitude;
	}
}
