package ui;

import java.io.IOException;

import members.Customer;
import bookings.Request;

public class MainMenu {
	public MainMenu() {
		while (true)
			printMainMenu();
	}

	private void printMainMenu() {
		System.out.println();
		System.out.println("=================================================");
		System.out.println("1. Customer Menu");
		System.out.println("2. Vehicle and Driver Menu");
		System.out.println("3. Staff Management Menu");
		System.out.println("0. Exit");
		System.out.println("Please Enter you Option: ");
		try {
			String line = MainStart.getReader().readLine();
			if (line.isEmpty() || line.length() >= 2) {
				System.out.println("Wrong Input. Please enter again.");
				printMainMenu();
			} else {
				int option = Integer.parseInt(line);
				switch (option) {
				case 0:
					System.out
							.println("You are logging out. Have a nice day!! :)");
					System.exit(0);
					break;
				case 1:
					printCustomerMenu();
					break;
				case 2:
					printDriverMenu();
					break;
				case 3:
					printStaffMenu();
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void printStaffMenu() {
		try {
			while (true) {
				System.out.println();
				System.out
						.println("Staff Management Menu____________________________________");
				System.out.println("1. Register for vehicle");
				System.out.println("2. Retrieve List of Vehicles");
				System.out.println("3. Search for Vehicle");
				System.out.println("4. Retrieve List of Customers");
				System.out.println("5. Search for Customer");
				System.out.println("0. Go to Main Menu");
				System.out.println("Please Enter you Option: ");
				String line = MainStart.getReader().readLine();
				if (line.isEmpty() || line.length() >= 2) {
					System.out.println("Wrong Input. Please enter again.");
					printMainMenu();
				} else {
					int option = Integer.parseInt(line);
					switch (option) {
					case 0:
						break;
					case 1:

						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					}
					if (option == 0) {
						break;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void printDriverMenu() {
		try {
			while (true) {
				System.out.println();
				System.out
						.println("Vehicle and Driver Menu____________________________________");
				System.out.println("1. Registration");
				System.out.println("2. Login");
				System.out.println("3. Subscribe for bid requests");
				System.out.println("0. Go to Main Menu");
				System.out.println("Please Enter you Option: ");
				String line = MainStart.getReader().readLine();
				if (line.isEmpty() || line.length() >= 2) {
					System.out.println("Wrong Input. Please enter again.");
					printMainMenu();
				} else {
					int option = Integer.parseInt(line);
					switch (option) {
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					}
					if (option == 0) {
						break;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void printCustomerMenu() {

		try {
			while (true) {
				System.out.println();
				System.out
						.println("Customer Menu____________________________________");
				System.out.println("1. Registration");
				System.out.println("2. Login");
				System.out.println("3. Request A Cab");
				System.out.println("4. Payment");
				System.out.println("0. Go to Main Menu");
				System.out.println("Please Enter you Option: ");
				String line = MainStart.getReader().readLine();
				if (line.isEmpty() || line.length() >= 2) {
					System.out.println("Wrong Input. Please enter again.");
					printMainMenu();
				} else {
					CustomerMenu customerMenu = new CustomerMenu();
					int option = Integer.parseInt(line);
					switch (option) {
					case 0:
						break;
					case 1:
						Customer customer = customerMenu.registration();
						if (customer != null) {
							customer.toString();
						}
						break;
					case 2:
						customerMenu.login();
						break;
					case 3:
						Request request = customerMenu.requestACab();
						if (request != null) {
							System.out.println("The Request is:");
							request.toString();
						}
						break;
					case 4:
						// customerMenu.makeAPayment();
						break;
					}
					if (option == 0) {
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}