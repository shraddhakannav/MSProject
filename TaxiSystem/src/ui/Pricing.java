package ui;

public class Pricing {
	private String cabType;
	private double normalRate;
	private double peakRate;

	public String getCabType() {
		return cabType;
	}

	public void setCabType(String cabType) {
		this.cabType = cabType;
	}

	public double getNormalRate() {
		return normalRate;
	}

	public void setNormalRate(double normalRate) {
		this.normalRate = normalRate;
	}

	public double getPeakRate() {
		return peakRate;
	}

	public void setPeakRate(double peakRate) {
		this.peakRate = peakRate;
	}
}
