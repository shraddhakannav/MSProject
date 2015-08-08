package vehicles;

public class InMaintenanceVehicleState implements IVehicleState {

	IVehicle vehicle;

	public InMaintenanceVehicleState(IVehicle v) {
		vehicle = v;
	}

	@Override
	public String becomeAvailable() {
		vehicle.setState(new OfflineVehicleState(vehicle));
		return "Vehicle is available after maintenance.";
	}

	@Override
	public String hireVehicle() {
		return "Vehicle is under maintenance.";
	}

	@Override
	public String doMaintenance() {
		return "Vehicle is under maintenance.";
	}

}
