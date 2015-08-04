package vehicles;

public class Vehicle implements IVehicle{
	
	IVehicleState state;
	
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
	
	
}
