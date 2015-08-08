package ui;

import java.io.BufferedReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import bookings.*;
import members.*;

public class CustomerMenu {

	private BufferedReader reader;
	private static Customer loggedCustomer;

	public static Customer getLoggedCustomer() {
		return loggedCustomer;
	}

	public static void setLoggedCustomer(Customer loggedCustomer) {
		CustomerMenu.loggedCustomer = loggedCustomer;
	}

	public CustomerMenu() {
		reader = MainStart.getReader();
	}

	public Customer registration() {

		try {

			Customer customer = new Customer();
			System.out.println();
			System.out
					.println("___________________________________________________________________");
			System.out.println("Customer registration form");
			System.out
					.println("___________________________________________________________________");
			System.out.println("Please enter details: ");

			System.out.println("Name: ");
			customer.setName(reader.readLine());

			System.out.println("Email: ");
			customer.setEmail(reader.readLine());

			System.out.println("Phone No: ");
			customer.setContactNo(reader.readLine());

			System.out.println("Membership Plan [basic/premium]: ");
			customer.setPlan(reader.readLine());

			System.out.println("Credit Card Number: ");
			customer.setCreditCardNo(reader.readLine());

			System.out.println("CVV: ");
			customer.setCvv(Integer.parseInt(reader.readLine()));

			System.out.println("Date of expiration[MM/yyyy]: ");

			customer.setExpirationDate(reader.readLine());

			System.out.println("Do you want to Submit registration? [y:n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {

				DataAccess da = new DataAccess();
				int i = da.insertCustomer(customer);
				if (i > 0) {
					System.out.println("You are successfully registered.");
					loggedCustomer = customer;
				}

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

	public void login() {
		try {
			System.out
					.println("___________________________________________________________________");
			System.out.println("Customer Login Details: ");

			System.out.println("Please Enter your Username: ");
			String username = reader.readLine();

			// System.out.println(username);
			DataAccess da = new DataAccess();
			Customer cust = da.retreiveCustomerByName(username);
			if (cust != null) {
				loggedCustomer = cust;
				System.out.println(username + "  "
						+ ",You are successfully logged into the system.");
			} else {
				System.out.println("You are not a registered user.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Request requestACab() {

		try {

			Request request = new Request();
			long time = System.currentTimeMillis();
			request.setRequestId(time);
			System.out.println();
			System.out
					.println("___________________________________________________________________");
			System.out.println("Request a ride ");
			System.out
					.println("___________________________________________________________________");
			System.out.println("Please enter details: ");

			System.out.println("Do you want to ride in Taxi or a InstantCab: ");
			request.setRequestType(reader.readLine());

			HashMap<String, Location> locations = LocationMapping
					.getLocationObject().getLocations();

			int count = 1;

			for (String string : locations.keySet()) {
				System.out.println(count++ + ". " + string);
			}

			System.out.println("Pick Up Location [pick from above list]: ");
			int index = Integer.parseInt(reader.readLine());
			String selected = (String) (locations.keySet().toArray()[index - 1]);

			Location location1 = locations.get(selected);

			request.setPickX(location1.x);
			request.setPickY(location1.y);
			request.setPickUpLocation(selected);

			System.out.println("Destination [pick from above list]:  ");
			index = Integer.parseInt(reader.readLine());
			selected = (String) (locations.keySet().toArray()[index - 1]);
			Location location2 = locations.get(selected);

			request.setDestX(location2.x);
			request.setDestY(location2.y);
			request.setDestination(selected);

			Date date = null;
			while (date == null) {
				date = getInputBookingDate();
				if (date == null) {
					System.out
							.println("Please enter the date in proper format.");
				}
			}

			request.setBookingDate(date);

			System.out.println("Enter Type [Basic/Luxury]: ");
			request.setCarType(reader.readLine());

			System.out.println("Do you want to bid for Cab [y/n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {
				Bid bid = new Bid();

				System.out.println("Suggest Your Fare Amount of the ride: ");
				bid.setFare(Double.parseDouble(reader.readLine()));

				request.setBid(bid);
			}

			System.out.println("Do you want a Car Seat [y/n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {
				// DECORATOR PATTERN TO ADD CAR SEAT FEATURE

				CarSeatDecorator decoratedRequest = new CarSeatDecorator(
						request);
				decoratedRequest.addCarSeat();
				// request.setCarSeatFlag(true);
			} else
				request.setCarSeatFlag(false);

			System.out.println("Do you want a pet friendly car [y/n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {

				// DECORATOR PATTERN TO ADD PET FRIENDLY FEATURE

				PetFriendlyDecorator decoratedRequest = new PetFriendlyDecorator(
						request);
				decoratedRequest.makePetFriendly();

				// request.setPetFriendlyFlag(true);
			} else
				request.setPetFriendlyFlag(false);

			double avg = calculateFare(request);
			request.setFareEstimation(avg);

			System.out.println("Do you want to submit a request? [y/n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {
				System.out
						.println("Your Request has been created. Please wait for connecting to drivers.");

				System.out.println(request.toString());

				// STATE PATTERN FOR DIFFERENT REQUEST STATES

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

	private java.sql.Date getInputBookingDate() {
		try {
			System.out.println("Booking Date[MM/dd/yyyy hh:mm]: ");

			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			java.util.Date parsed = (java.util.Date) format.parse(reader
					.readLine());
			return new java.sql.Date(parsed.getTime());
		} catch (Exception e) {
		}
		return null;
	}

	private double calculateFare(Request request) {
		// TODO Auto-generated method stub

		int x1 = request.getPickX();
		int x2 = request.getPickY();
		int y1 = request.getDestX();
		int y2 = request.getDestY();

		double power = Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2);
		double distance = Math.sqrt(power);

		Pricing p = new DataAccess().retreivePricing(request.getRequestType(),
				request.getCarType());
		while (p != null) {

			double fareNormal = p.getNormalRate() * distance;
			double farePeak = p.getPeakRate() * distance;
			double avg = (fareNormal + farePeak) / 2;

			return avg;
		}
		return 0;
	}
}
