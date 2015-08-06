package vehicles;


public class Vehicle implements IVehicle {

	IVehicleState state;
	private int vehicleId;
	private String vehicleColor;
	private String vehicleType;
	private String modelNo;
	private String licensePlate;
	private String driverName;

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

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

}
