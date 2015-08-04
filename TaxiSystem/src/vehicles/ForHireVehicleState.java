package vehicles;

public class ForHireVehicleState implements IVehicleState {

	IVehicle vehicle;

	public ForHireVehicleState(IVehicle v) {
		vehicle = v;
	}

	@Override
	public String becomeAvailable() {
		return "Vehicle is already available.";
	}

	@Override
	public String hireVehicle() {
		vehicle.setState(new HiredVehicleState(vehicle));
		return "Vehicle has been hired.";
	}

	@Override
	public String doMaintenance() {
		vehicle.setState(new InMaintenanceVehicleState(vehicle));
		return "Vehicle is under maintenance";
	}

}
