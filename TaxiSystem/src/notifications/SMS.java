package notifications;

public class SMS extends Communication1 {

	
	

	@Override
	public void notifyCustomer(String message) {
		// TODO Auto-generated method stub
		
		System.out.println("Sending SMS: '" + message + "' to Customer");
	}
	@Override
	public void notifyDriver(String message){
		System.out.println("Sending SMS: '" + message + "' to Driver");
	}
		
	}


