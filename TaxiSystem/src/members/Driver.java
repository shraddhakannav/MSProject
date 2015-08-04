package members;

import java.sql.Date;
import java.util.ArrayList;

public class Driver extends Member {

	String licenceNo;
	Date registrationDate;
	ArrayList<String> shiftDays;
	double shiftStartTime;
	double shiftEndTime;

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public ArrayList<String> getShiftDays() {
		return shiftDays;
	}

	public void setShiftDays(ArrayList<String> shiftDays) {
		this.shiftDays = shiftDays;
	}

	public double getShiftStartTime() {
		return shiftStartTime;
	}

	public void setShiftStartTime(double shiftStartTime) {
		this.shiftStartTime = shiftStartTime;
	}

	public double getShiftEndTime() {
		return shiftEndTime;
	}

	public void setShiftEndTime(double shiftEndTime) {
		this.shiftEndTime = shiftEndTime;
	}

	@Override
	public String toString() {

		String string = this.getFirstName() + "" + this.getLastName()
				+ "(address: " + this.getAddress() + ", email: "
				+ this.getEmail() + ", Contact No: " + this.getContactNo()
				+ ") DOB: " + this.getDOB() + " " + this.gender;

		String driverStr = "\nRegistartion Date: "
				+ this.getRegistrationDate() + " [" + this.getShiftStartTime()
				+ " to " + this.getShiftEndTime() + " on "
				+ this.getShiftDays() + "]";

		return string + " " + driverStr;
	}
}
