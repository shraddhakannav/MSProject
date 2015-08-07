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

	public Vehicle registerForVehicle() {

		try {

			Vehicle vehicle = new Vehicle();
			System.out.println();
			System.out
					.println("___________________________________________________________________");
			System.out.println("Vehicle registration form");
			System.out
					.println("___________________________________________________________________");
			System.out.println("Please enter details: ");

			System.out.println("Vehicle Color: ");
			vehicle.setVehicleColor(reader.readLine());

			System.out.println("Vehicle Type: ");
			vehicle.setVehicleType(reader.readLine());

			System.out.println("Car Model No: ");
			vehicle.setModelNo(reader.readLine());

			System.out.println("License Plate No: ");
			vehicle.setLicensePlate(reader.readLine());

			System.out.println("Enter Driver Name: ");
			vehicle.setDriverName(reader.readLine());

			System.out.println("Do you want to Submit registration? [y:n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {

				DataAccess da = new DataAccess();
//				da.insertVehicle(vehicle);

				System.out.println("Vehicle is successfully registered.");
				return vehicle;

			} else {
				System.out.println("Successfully Cancelled.");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out
				.println("You are not registered as some values are either empty or not set properly.");
		return null;
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
			vehicleList = da.retreiveDriverByStatus("available");

			if (vehicleList != null) {
				for (Driver vehicle : vehicleList) {
					System.out.println();
					System.out.println(vehicle.toString());
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
			Vehicle vehicle = null;
			vehicle = da.retreivebyvehicleId(vehicleid);
			if (vehicle != null) {
				System.out.println(vehicle.toString());
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
			customerList = da.retreiveallCustomers();
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
			String customerId = reader.readLine();

			DataAccess da = new DataAccess();
			Customer customer = null;
			customer = da.retreiveCustomerById(customerId);
			if (customer != null) {
				customer.toString();
			}
			System.out.println();

			updateDeleteCustomerMenu(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateDeleteCustomerMenu(Customer customer) {
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
				Customer updatedcustomer = updateForCustomer(customer);
				break;
			case "delete":
				System.out.println();
				System.out.println("Delete the current selected record:");
				DataAccess da = new DataAccess();
				da.deleteCustomer(customer);
				System.out.println("Vehicle Successfully deleted.");
				break;
			case "exit":
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateDeleteVehicleMenu(Vehicle vehicle) {
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
				Vehicle updatedVehicle = updateForVehicle(vehicle);
				break;
			case "delete":
				System.out.println();
				System.out.println("Delete the current selected record:");
				DataAccess da = new DataAccess();
				da.deleteVehicle(vehicle);
				System.out.println("Vehicle Successfully deleted.");
				break;
			case "exit":
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Vehicle updateForVehicle(Vehicle vehicle) {

		try {

			System.out.println();
			System.out
					.println("___________________________________________________________________");
			System.out.println("Vehicle update form");
			System.out
					.println("___________________________________________________________________");
			System.out.println("Please enter values for fields to update: ");
			String input = "";

			System.out.println("Vehicle Color [ " + vehicle.getVehicleColor()
					+ " ]: ");
			input = (reader.readLine());
			if (!input.trim().isEmpty())
				vehicle.setVehicleColor(input);

			System.out.println("Vehicle Type: [ " + vehicle.getVehicleType()
					+ " ]:");
			input = (reader.readLine());
			if (!input.trim().isEmpty())
				vehicle.setVehicleType(input);

			System.out.println("Car Model No: [ " + vehicle.getModelNo()
					+ " ]:");
			input = (reader.readLine());
			if (!input.trim().isEmpty())
				vehicle.setModelNo(input);

			System.out.println("License Plate No: [ "
					+ vehicle.getLicensePlate() + " ]:");
			input = (reader.readLine());
			if (!input.trim().isEmpty())
				vehicle.setLicensePlate(input);

			System.out.println("Enter Driver Name: [ "
					+ vehicle.getDriverName() + " ]:");
			input = (reader.readLine());
			if (!input.trim().isEmpty())
				vehicle.setDriverName(input);

			System.out.println("Do you want to Submit Updating? [y:n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {

				DataAccess da = new DataAccess();
				da.UpdateVehicleDetails(vehicle);
				System.out.println("Vehicle is updated successfully.");
				return vehicle;

			} else {
				System.out.println("Successfully Cancelled.");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out
				.println("You are not registered as some values are either empty or not set properly.");
		return null;
	}

	public Customer updateForCustomer(Customer customer) {

		try {

			System.out.println();
			System.out
					.println("___________________________________________________________________");
			System.out.println("Customer update form");
			System.out
					.println("___________________________________________________________________");
			System.out.println("Please enter values for fields to update: ");
			String input = "";
			System.out.println("Name: [ " + customer.getName() + " ]:");
			input = (reader.readLine());
			if (!input.trim().isEmpty())

				customer.setName(input);

			System.out.println("Email: [ " + customer.getEmail() + " ]:");
			input = (reader.readLine());
			if (!input.trim().isEmpty())

				customer.setEmail(input);

			System.out
					.println("Phone No: [ " + customer.getContactNo() + " ]:");
			input = (reader.readLine());
			if (!input.trim().isEmpty())

				customer.setContactNo(input);

			System.out.println("Membership Plan [basic/premium]: [ "
					+ customer.getPlan() + " ]:");
			input = (reader.readLine());
			if (!input.trim().isEmpty())

				customer.setPlan(input);

			System.out.println("Credit Card Number: [ "
					+ customer.getCreditCardNo() + " ]:");
			input = (reader.readLine());
			if (!input.trim().isEmpty())

				customer.setCreditCardNo(input);

			System.out.println("CVV: [ " + customer.getCvv() + " ]:");
			input = (reader.readLine());
			if (!input.trim().isEmpty())

				customer.setCvv(Integer.parseInt(input));

			System.out.println("Date of expiration[MM/yyyy]: [ "
					+ customer.getExpirationDate() + " ]:");
			input = (reader.readLine());
			if (!input.trim().isEmpty())

				customer.setExpirationDate(input);

			System.out.println("Do you want to Submit update? [y:n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {

				DataAccess da = new DataAccess();
				da.updateCustomerDetails(customer);

				System.out.println("You are successfully Updated.");
				return customer;

			} else {
				System.out.println("Successfully Cancelled.");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out
				.println("You are not registered as some values are either empty or not set properly.");
		return null;
	}

}
