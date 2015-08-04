package reports;

public class StaffReport extends Reports {

	public StaffReport(String reportDescription) {
		this();
		typeOfReport = "Staff Report";
		this.reportDescription = reportDescription;
	}

	public StaffReport() {
		typeOfReport = "Staff Report";
	}

	@Override
	public void showReport() {
		super.showReport();
	}
}
