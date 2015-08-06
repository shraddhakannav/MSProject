package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import bookings.*;
import members.*;

public class DriverMenu {

	private BufferedReader reader;

	private Driver loggedDriver;

	public DriverMenu() {
		reader = MainStart.getReader();
	}

	public Driver registration() {

		try {

			Driver driver = new Driver();
			System.out.println();
			System.out
					.println("___________________________________________________________________");
			System.out.println("Driver registration form");
			System.out
					.println("___________________________________________________________________");
			System.out.println("Please enter details: ");

			System.out.println("Name: ");
			driver.setName(reader.readLine());

			System.out.println("Email: ");
			driver.setEmail(reader.readLine());

			System.out.println("Phone No: ");
			driver.setContactNo(reader.readLine());

			System.out.println("Driver License Number: ");
			driver.setLicenceNo(reader.readLine());

			System.out.println("Vehicle Registration Date : ");
			driver.setRegistrationDate(reader.readLine());

			System.out.println("Shift Start Time");
			driver.setShiftStartTime(reader.readLine());

			System.out.println("Shift End Time");
			driver.setShiftEndTime(reader.readLine());

			System.out.println("Do you want to Subscribe for bidding? [y:n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {
				driver.setObserver(true);
			} else {
				driver.setObserver(false);
			}

			System.out.println("Do you want to Submit registration? [y:n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {
				System.out.println("You are successfully registered.");

				loggedDriver = driver;

				return driver;

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

	public void login() {
		try {
			System.out
					.println("___________________________________________________________________");
			System.out.println("Driver Login Details: ");

			System.out.println("Please Enter your Username: ");
			String username = reader.readLine();

			// System.out.println("Please Enter your Password: ");
			// String password = reader.readLine();
			//
			// if(username.equals(password)) {
			//
			// }

			System.out.println(username);
			// DataAccess da = new DataAccess();
			// Driver driver = da.fetchdriver(username);
			// if (driver != null) {
			// loggedDriver = driver;
			// System.out.println("You are successfully logged into the system.");
			// } else {
			// System.out.println("You are not a registered driver.");
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Request subscribeBid() {

		try {

			Bid bid = new Bid();
			loggedDriver.setObserver(true);

			bid.addObserver(loggedDriver);
			System.out
					.println("Dear Driver: "
							+ loggedDriver.getName()
							+ ", you are successfully subscribed to the bidding fares.");

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Your request is not complete. Please try again.");
		return null;

	}

	public Driver getLoggedDriver() {
		return loggedDriver;
	}

	public void setLoggedDriver(Driver loggedDriver) {
		this.loggedDriver = loggedDriver;
	}
}
