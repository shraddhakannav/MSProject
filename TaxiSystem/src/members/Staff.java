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

		String staffStr = "[" + this.getBranchName() + "(" + this.getBranchId()
				+ ")" + this.getDesignation() + "]";

		return super.toString() + " " + staffStr;
	}
}
