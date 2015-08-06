package members;

import java.sql.Date;
import java.util.ArrayList;

import bookings.Fare;

public class Driver extends Member {

	String licenceNo;
	String registrationDate;
	ArrayList<String> shiftDays;
	String shiftStartTime;
	String shiftEndTime;

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

		String driverStr = "\nRegistartion Date: " + this.getRegistrationDate()
				+ " [" + this.getShiftStartTime() + " to "
				+ this.getShiftEndTime() + " on " + this.getShiftDays() + "]";

		return super.toString() + " " + driverStr;
	}

	// Observer Pattern for bidding
	@Override
	public void update(Fare fare, String message) {
		System.out.println("Notified Driver: " + this.getName());
		if (message != null && !message.isEmpty()) {
			System.out.println("The message is: " + message);
		}

	}
}
