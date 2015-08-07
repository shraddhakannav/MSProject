package bookings;

import java.io.IOException;
import java.util.List;

import ui.MainStart;
import members.Driver;

public class BiddingClient {

	public void startBidding(Request request) {
		try {
			Bid bid = request.getBid();

			bid.setRequest(request);

			DataAccess da = new DataAccess();
			List<Driver> list = da.retreiveallDrivers();
			for (Driver driver : list) {
				if (driver.isObserver()) {
					bid.addObserver(driver);
				}
			}

			System.out.println();
			System.out.println("Current bidding fare is " + bid.getFare());
			System.out.println("Do you want to raise a bid? [y:n]: ");
			if (MainStart.getReader().readLine().equalsIgnoreCase("y")) {
				System.out.println("State your current bid: $");
				String biddingamount;
				biddingamount = MainStart.getReader().readLine();
				double amount = Double.parseDouble(biddingamount);
			}
			bid.setFare(bid.getFare());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
	}
}
