package reports;

public class ReportSetup {

	public void setup() {

		DriverReport driver1 = new DriverReport("Driver 1 Reports");
		DriverReport driver2 = new DriverReport("Driver 2 Reports");

		StaffReport staff1 = new StaffReport("Staff 1 reports");
		StaffReport staff2 = new StaffReport("Staff 2 reports");

		SalesReport sales = new SalesReport("Sales");
		sales.addReport(driver1);
		sales.addReport(staff1);

		PerformanceReport performance = new PerformanceReport("Performance");
		performance.addReport(driver2);
		performance.addReport(staff2);

		PerformanceReport companyPerformance = new PerformanceReport(
				"Company Performance");
		companyPerformance.addReport(performance);
		companyPerformance.addReport(sales);
		
		companyPerformance.showReport();

	}

}
