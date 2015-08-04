package members;

import java.sql.Date;

public class Customer extends Member {

	double creditCardNo;
	int cvv;
	Date expirationDate;
	String membershipPlan;

	@Override
	public String toString() {

		String string = this.getFirstName() + "" + this.getLastName()
				+ "(address: " + this.getAddress() + ", email: "
				+ this.getEmail() + ", Contact No: " + this.getContactNo()
				+ ") DOB: " + this.getDOB() + " " + this.gender;

		return string;
	}
}
