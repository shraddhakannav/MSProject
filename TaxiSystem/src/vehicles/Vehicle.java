package vehicles;

import members.Driver;

public class Vehicle implements IVehicle {

	IVehicleState state;
	private int vehicleId;
	private String vehicleColor;
	private String vehicleType;
	private String modelNo;
	private String licensePlate;
	private Driver driver;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public IVehicleState getState() {
		return state;
	}

	public void setState(IVehicleState state) {
		this.state = state;
	}

	public Vehicle() {
		state = new OffilineVehicleState(this);
		System.out.println("In Vehicle Constructor");
	}

	public void becomeAvailable() {
		System.out.println("become Available: " + state.becomeAvailable());
	}

	public void hireVehicle() {
		System.out.println("Hire vehicle: " + state.hireVehicle());
	}

	public void doMaintenance() {
		System.out.println("Do Maintenance: " + state.doMaintenance());
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

}
