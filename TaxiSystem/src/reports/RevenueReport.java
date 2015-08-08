package reports;

import java.util.Vector;

public abstract class RevenueReport extends Reports {

	protected Vector<Reports> directReports = new Vector<Reports>();

	public void showReport() {

		super.showReport();

		if (directReports.size() > 0) {

			for (Reports report : directReports) {

				report.showReport();

			}

		}

	}

	public void addReport(Reports report) {

		directReports.addElement(report);

		// System.out.println("Report has been added: " + report);

	}

}