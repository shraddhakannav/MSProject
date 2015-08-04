package members;

public class Staff extends Member {

	String branchId;
	String branchName;
	String designation;

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {

		String string = this.getFirstName() + "" + this.getLastName()
				+ "(address: " + this.getAddress() + ", email: "
				+ this.getEmail() + ", Contact No: " + this.getContactNo()
				+ ") DOB: " + this.getDOB() + " " + this.gender;

		String staffStr = "[" + this.getBranchName() + "(" + this.getBranchId()
				+ ")" + this.getDesignation() + "]";

		return string + " " + staffStr;
	}
}
