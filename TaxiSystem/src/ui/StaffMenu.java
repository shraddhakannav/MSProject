package ui;

import java.io.BufferedReader;
import java.util.List;

import members.Customer;
import members.Driver;
import vehicles.Vehicle;
import bookings.DataAccess;

public class StaffMenu {

	private BufferedReader reader;

	public StaffMenu() {
		reader = MainStart.getReader();
	}

	// System.out.println("1. Register for vehicle");
	// System.out.println("2. Retrieve List of Vehicles");
	// System.out.println("3. Search for Vehicle");
	// System.out.println("4. Retrieve List of Customers");
	// System.out.println("5. Search for Customer");

	public void registerForVehicle() {

		try {
			// Priya's code

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void retrieveListOfVehicles() {
		try {
			System.out
					.println("_______________________________________________________________");
			System.out.println("List Of Vehicles: ");
			System.out
					.println("_______________________________________________________________");

			DataAccess da = new DataAccess();
			List<Driver> vehicleList = null;
			// vehicleList = da.retreievealldrivers();
			if (vehicleList != null) {
				for (Driver vehicle : vehicleList) {
					vehicle.toString();
				}
			}
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void searchForVehicle() {
		try {
			System.out.println();
			System.out.println("Please enter the Vehicle ID: ");
			String vehicleid = reader.readLine();

			DataAccess da = new DataAccess();
			List<Vehicle> vehicleList = null;
			// vehicleList = da.retreivebyvehicleId(vehicleid);
			if (vehicleList != null) {
				for (Vehicle vehicle : vehicleList) {
					vehicle.toString();
				}
			}
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void retrieveListOfCustomers() {
		try {
			System.out
					.println("_______________________________________________________________");
			System.out.println("List Of Customers: ");
			System.out
					.println("_______________________________________________________________");

			DataAccess da = new DataAccess();
			List<Customer> customerList = null;
			// customerList = da.retreiveallcustomers();
			if (customerList != null) {
				for (Customer customer : customerList) {
					customer.toString();
				}
			}
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void searchForCustomer() {
		try {
			System.out.println();
			System.out.println("Please enter the Customer ID: ");
			String customerid = reader.readLine();

			DataAccess da = new DataAccess();
			List<Customer> customerList = null;
			// customerList = da.retreivebyCustomerId(customerId);
			if (customerList != null) {
				for (Customer customer : customerList) {
					customer.toString();
				}
			}
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateDeleteMenu() {
		try {
			System.out.println();
			System.out.println("______________________");
			System.out.println("Update the record");
			System.out.println("Delete the record");
			System.out.println("Select your option [update/delete/exit]: ");
			String command = reader.readLine();
			switch (command.toLowerCase()) {
			case "update":
				System.out.println();
				System.out.println("Update the current selected record:");
				break;
			case "delete":
				break;
			case "exit":
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
