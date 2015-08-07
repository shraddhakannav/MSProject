package ui;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import bookings.*;
import members.*;

public class CustomerMenu {

	private BufferedReader reader;
	private static Customer loggedCustomer;

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
				da.insertCustomer(customer);
				
				System.out.println("You are successfully registered.");
				loggedCustomer = customer;
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

			System.out.println(username);
			DataAccess da = new DataAccess();
			Customer cust = da.retreiveCustomerByName(username);
			if (cust != null) {
				loggedCustomer = cust;
				System.out
						.println("You are successfully logged into the system.");
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
			System.out.println();
			System.out
					.println("___________________________________________________________________");
			System.out.println("Request A Cab Details");
			System.out
					.println("___________________________________________________________________");
			System.out.println("Please enter details: ");

			System.out.println("Do you want to ride in Taxi or Instant Cab: ");
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

			System.out.println("Booking Date[MM/dd/yyyy hh:mm]: ");

			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			java.util.Date parsed = (java.util.Date) format.parse(reader
					.readLine());
			java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());

			request.setBookingDate(sqlDate);

			System.out.println("Car Type [instant/luxury/taxi]: ");
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
				bid.setFare(Double.parseDouble(reader.readLine()));

				request.setBid(bid);
			}

			calculateFare(request);

			System.out.println("Do you want to submit a request? [y/n]: ");
			if (reader.readLine().equalsIgnoreCase("y")) {
				System.out
						.println("Your Request has been created. Please wait for connecting to drivers.");

				System.out.println(request.toString());
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

	private void calculateFare(Request request) {
		// TODO Auto-generated method stub

		int x1 = request.getPickX();
		int x2 = request.getPickY();
		int y1 = request.getDestX();
		int y2 = request.getDestY();

		double power = Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2);
		double distance = Math.sqrt(power);
		
		
		

	}
}
