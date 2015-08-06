package members;

import java.sql.Date;

public class Customer extends Member {

	double creditCardNo;
	int cvv;
	String expirationDate;

	public double getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(double creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}


	@Override
	public String toString() {
		return super.toString();
	}
}
