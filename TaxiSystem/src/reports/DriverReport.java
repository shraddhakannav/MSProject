package reports;

public class DriverReport extends Reports {

	public DriverReport(String reportDescription) {
		this();
		typeOfReport = "Driver Report";
		this.reportDescription = reportDescription;
	}

	public DriverReport() {
		typeOfReport = "Driver Report";
	}

	@Override
	public void showReport() {
		super.showReport();
	}

}
