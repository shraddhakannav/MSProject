package dispatch;

import java.io.BufferedReader;
import payments.PaymentType;
import java.io.InputStreamReader;
import java.util.ArrayList;

import members.Driver;
import ui.MainMenu;
import bookings.BiddingClient;
import bookings.DataAccess;
import bookings.Request;

public class Dispatcher implements DispatcherInterface {

	public void dispatchRequest(Request request)
	// public static void main(String arg[])
	{
		try {

			RideClass rideClass = new RideClass();
			boolean is_start = false;
			boolean cancel_ride = false;
			boolean noAvailableDrivers = true;
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			DataAccess dataAccess = new DataAccess();
			Driver confirmedDriver = new Driver();
			String status = "delay";
			String command = "-1";
			int flag = -1; // 0 for instant cab 1 for taxi

			// ************ BRIDGE PATTERN *************//
			VehicleType v1;
			Algorithm algorithm;
			ArrayList driver_list = dataAccess
					.retreiveDriverByStatus("for_hire");
			ArrayList pass_argument = new ArrayList();
			pass_argument.add(request);
			pass_argument.add(driver_list);

			if (request.getRequestType().equalsIgnoreCase("InstantCab")) {
				algorithm = new Algorithm1();
				v1 = new InstantCab(algorithm);
				flag = 0;
			} else {
				algorithm = new Algorithm2();
				v1 = new Taxi(algorithm);
				flag = 1;
			}

			ArrayList<Driver> result = null;

			if (request.getBid() == null) {
				result = v1.callAlgorithm(pass_argument);
			} else {
				// Calling Observer pattern
				request.getBid().setRequest(request);
				BiddingClient client = new BiddingClient();
				result = client.startBidding(request); 
			}

			// ArrayList result=v1.callAlgorithm(pass_argument);
			if (result == null || result.size() == 0) {
				System.out.println("No Drivers Available. Kindly try after some time.");
				MainMenu mainMenu = new MainMenu();
			}
			// System.out.println("result  "+result);

			// ************ BRIDGE PATTERN ENDS *************//
			if (flag == 0) {
				while (noAvailableDrivers) {
					for (int i = 0; i < result.size(); i++) {
						Driver temp = (Driver) result.get(i);

						System.out.println("");
						System.out.println("");
						System.out.println("Driver No " + temp.getId()
								+ " do you want to accept this Ride? [Y/N]");
						System.out.println("");
						String s = bufferRead.readLine();
						if (s.equalsIgnoreCase("Y")) {
							confirmedDriver = temp;
							i = result.size();
							vehicles.Vehicle vehicle = dataAccess
									.retreiveVehicleByDriver(confirmedDriver
											.getName());
							System.out.println("");
							System.out
									.println("Dear Customer your ride is confirmed. These are the details : :");
							System.out.println("Driver Name : "
									+ vehicle.getDriverName());
							System.out.println("Vehicle Licence : "
									+ vehicle.getLicensePlate());
							System.out.println("Vehicle Color : "
									+ vehicle.getVehicleColor());
							noAvailableDrivers = false;

						}

					} // drivers confirmed
				}
			}

			else {
				Driver temp = (Driver) result.get(0);
				confirmedDriver = temp;
				vehicles.Vehicle vehicle = dataAccess
						.retreiveVehicleByDriver(temp.getName());
				System.out.println("");
				System.out
						.println("Dear Customer your ride is confirmed. These are the details : :");
				System.out.println("Driver Name : " + vehicle.getDriverName());
				System.out.println("Vehicle Licence : "
						+ vehicle.getLicensePlate());
				System.out.println("Vehicle Color : "
						+ vehicle.getVehicleColor());
			}

			do {
				System.out.println("");

				System.out.println("*****For Driver*******");
				System.out.println(" 1 : Start Ride");
				System.out.println(" 2 : End Ride");
				System.out.println(" 3 : Delay Ride");
				System.out.println("");
				System.out.println("******For User******");
				System.out.println(" 4 : Cancel Ride");

				String s = bufferRead.readLine();
				command = s;
				if (s.equals("1") && !is_start) {
					is_start = true;
					rideClass.startRide();
				} else if (s.equals("1") && is_start) {
					System.out.println("Ride is already started.");
				}

				else if (s.equals("2") && !is_start) {
					System.out.println("Ride is not even started.");
					command = "-1";
				} else if (s.equals("3") && !is_start) {
					System.out
							.println("Dear Customer your ride will be delayed by some minute");
				} else if (s.equals("3") && is_start) {
					System.out
							.println("Ride is already started. Cant delay it. Invalid selection");
				} else {
					if (s.equals("4"))
						cancel_ride = true;
					rideClass.modifyRide(s);
					command = "-2";
				}
			} while (!command.equals("-2"));

			// /if ride is cancelledd

			if (cancel_ride) {
				System.out.println("Your Ride is cancelled.");
				MainMenu mainMenu = new MainMenu();
			}

			// while(status.equalsIgnoreCase("delay"))
			// {
			// status=rideClass.modifyRide();
			// if(status.equalsIgnoreCase("delay"))
			// rideClass.delayRide();
			// }
			//
			// if(status.equalsIgnoreCase("cancel"))
			// {
			// rideClass.cancelRide();
			// }
			// else
			// rideClass.endRide();

			rideClass.setRequest_id(request.getRequestId());
			rideClass.setDriver_id(confirmedDriver.getId());
			rideClass.setStart_time(new java.util.Date());
			rideClass.setEnd_time(new java.util.Date());
			rideClass.setFare(request.getFareEstimation());

			rideClass.setDriver_rating(0);
			rideClass.setUser_rating(0);
			rideClass.setStatus("Completed");

			rideClass.makePayment(rideClass);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}