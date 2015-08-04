package reports;

public class PerformanceReport extends RevenueReport {

	public PerformanceReport(String reportDescription) {
		this();
		typeOfReport = "Performance Report";
		this.reportDescription = reportDescription;
	}

	public PerformanceReport() {
		super();
		typeOfReport = "Performance Report";
	}

	@Override
	public void showReport() {
		System.out.println("#.Performance Reports: ");
		super.showReport();
	}
}
