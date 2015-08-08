package notifications;

public class Phone extends Communication1 {

	@Override
	public void notifyCustomer(String message) {
		// TODO Auto-generated method stub
		
		System.out.println("Notifying via phone: " + message + " to Customer");
	}
	@Override
	public void notifyDriver(String message){
		System.out.println("Notifying via phone: " + message + " to Driver");
	}
	
	}


