package reports;

public class SalesReport extends RevenueReport {

	public SalesReport(String reportDescription) {
		this();
		typeOfReport = "Sales Report";
		this.reportDescription = reportDescription;
	}

	public SalesReport() {
		super();
		typeOfReport = "Sales Report";
	}

	@Override
	public void showReport() {
		System.out.println("#.Sales Reports: ");
		super.showReport();
	}
}
