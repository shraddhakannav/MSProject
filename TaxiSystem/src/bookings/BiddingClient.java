package bookings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ui.MainStart;
import members.Driver;

public class BiddingClient {

	public ArrayList<Driver> startBidding(Request request) {
		try {
			Bid bid = request.getBid();
			ArrayList<Driver> driverList = new ArrayList<Driver>();

			bid.setRequest(request);

			DataAccess da = new DataAccess();
			List<Driver> list = da.retreiveDriverByStatus("for_hire");
			for (Driver driver : list) {
				if (driver.isObserver()) {
					bid.addObserver(driver);
					driverList.add(driver);
				}
			}

			System.out.println();
			System.out.println("Current bidding fare is " + bid.getFare());
			// System.out.println("Do you want to raise a bid? [y:n]: ");
			// if (MainStart.getReader().readLine().equalsIgnoreCase("y")) {
			// System.out.println("State your current bid: $");
			// String biddingamount;
			// biddingamount = MainStart.getReader().readLine();
			// double amount = Double.parseDouble(biddingamount);
			// }
			bid.setFare(bid.getFare());
			// System.out.println(driverList);s
			return driverList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
			return null;
		}
	}
}
