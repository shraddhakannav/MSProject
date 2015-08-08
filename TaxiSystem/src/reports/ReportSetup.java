package reports;

public class ReportSetup {

	public void setup() {

		DriverReport driverSales = new DriverReport("Driver Sales");
		DriverReport driverPerformance = new DriverReport("Driver Performance");

		StaffReport staffSales = new StaffReport("Staff Sales");
		StaffReport staffPerformance = new StaffReport("Staff Performance");

		SalesReport sales = new SalesReport("Sales");
		sales.addReport(driverSales);
		sales.addReport(staffSales);

		PerformanceReport performance = new PerformanceReport("Performance");
		performance.addReport(driverPerformance);
		performance.addReport(staffPerformance);

		PerformanceReport companyPerformance = new PerformanceReport(
				"Company Performance");
		companyPerformance.addReport(performance);
		companyPerformance.addReport(sales);
		
		companyPerformance.showReport();

	}

}