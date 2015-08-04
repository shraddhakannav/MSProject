package reports;

public abstract class Reports {

	public String typeOfReport;
	public String reportDescription;

	public void showReport() {
		System.out.println(typeOfReport + ": " + this.reportDescription);
	}
}
