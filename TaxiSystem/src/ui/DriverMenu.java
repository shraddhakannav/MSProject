package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import bookings.*;
import members.*;

public class DriverMenu {

	private BufferedReader reader;

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
			
			System.out.println("Do you want to Submit registration? [y:n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {
				System.out.println("You are successfully registered.");

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
		// TODO Auto-generated method stub

	}

	public Request subscribeBid() {

		try {

			Request request = new Request();
			System.out.println();
			System.out
					.println("___________________________________________________________________");
			System.out.println("Request A Cab Details");
			System.out
					.println("___________________________________________________________________");
			System.out.println("Please enter details: ");

			System.out.println("Do you want to Subscribe for Bid requests ?: ");
			rtequest.setRequestType(reader.readLine());

			System.out.println("Pick Up Location: ");
			request.setPickUpLocation(reader.readLine());

			System.out.println("Destination: ");
			request.setDestination(reader.readLine());

			System.out.println("Booking Date[MM/dd/yyyy hh:mm]: ");

			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			java.util.Date parsed = (java.util.Date) format.parse(reader
					.readLine());
			java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());

			request.setBookingDate(sqlDate);

			System.out.println("Car Type: ");
			request.setCarType(reader.readLine());

			System.out.println("Do you want a Car Seat [y/n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {
				request.setCarSeatFlag(true);
			} else
				request.setCarSeatFlag(false);

			System.out.println("Do you want a pet friendly car [y/n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {
				request.setPetFriendlyFlag(true);
			} else
				request.setPetFriendlyFlag(false);

			System.out.println("Do you want to bid for Cab [y/n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {
				Bid bid = new Bid();

				System.out.println("Suggest Your Fare Amount of the ride: ");
				bid.setFare(Integer.parseInt(reader.readLine()));

				request.setBid(bid);

			}

			System.out.println("Do you want to submit a request? [y/n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {
				System.out
						.println("Your Request has been created. Please wait for connecting to drivers.");
				return request;

			} else {
				System.out
						.println("You cancelled the request. Please try again");
				return null;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Your request is not complete. Please try again.");
		return null;

	}
}
