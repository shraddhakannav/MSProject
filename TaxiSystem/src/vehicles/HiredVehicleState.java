package vehicles;

public class HiredVehicleState implements IVehicleState {

	IVehicle vehicle;
	
	public HiredVehicleState(IVehicle v) {
		vehicle = v;
	}
	
	@Override
	public String becomeAvailable() {
		vehicle.setState(new ForHireVehicleState(vehicle));
		return "Vehicle is available again.";
	}

	@Override
	public String hireVehicle() {
		return "Vehicle is already hired.";
	}

	@Override
	public String doMaintenance() {
		return "Vehicle is not available.";
	}

}
