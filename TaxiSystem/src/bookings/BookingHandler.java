package bookings;

import policies.DispatchRules;

public class BookingHandler {

//	public static void main(String[] args) {
//
//		new BookingHandler().bookRequest();
//	}
	
	public void bookRequest(){

		//		Bid bid = new Bid();
		//		Date date = new Date();
		//		String requestType = "Mobile";
		//		//	String requestType, String pickUplocation, String destination, Date bookingDate, String CarType, Bid bid)
		//
		//		if(requestType.equalsIgnoreCase("Mobile") || requestType.equalsIgnoreCase("Website") ){
		//
		//			Request request = new Request("Mobile","1234 ABC Street","1245 BCA Street",date,"Taxi",bid);
		//
		//			// Add both decorators to the request
		//			PetFriendlyDecorator pd = new PetFriendlyDecorator(request);
		//			CarSeatDecorator cd = new CarSeatDecorator(request);
		//
		//			// put in waiting state
		//			request.waitInQueue();
		//			// start processing
		//			request.processRequest();
		//
		//			try {
		//				DataAccess da = new DataAccess();
		//				// insert request to database
		//				da.insertRequest(request, 1234);
		//			}
		//
		//			catch (SQLException e) {
		//				System.out.println("Error in inserting request after processing");
		//				e.printStackTrace();
		//			}
		//
		//		}
		//		else{
		//			System.out.println("Vehicle manually hailed.");
		//		}

		DispatchRules rule = new DispatchRules();
		rule.makeARule();
	}

	public void cancelRequest(){


	}
}
