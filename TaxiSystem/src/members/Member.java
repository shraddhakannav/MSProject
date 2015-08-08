package members;

import java.sql.Date;

import bookings.Fare;

public abstract class Member {

	int id;
	private String name;
	// String address;
	String contactNo;
	String email;

	// String gender;
	// Date DOB;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// public String getAddress() {
	// return address;
	// }
	//
	// public void setAddress(String address) {
	// this.address = address;
	// }

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// public String getGender() {
	// return gender;
	// }
	//
	// public void setGender(String gender) {
	// this.gender = gender;
	// }

	// public Date getDOB() {
	// return DOB;
	// }
	//
	// public void setDOB(Date dOB) {
	// DOB = dOB;
	// }

	public String toString() {
		String string = this.id + ": " + this.getName() + "(email: "
				+ this.getEmail() + ", Contact No: " + this.getContactNo()
				+ ") ";
				return string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Observer Pattern for bidding
	public void update(Fare fare, String message) {
	}

}
