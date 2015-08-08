package notifications;

public class CustomerNotifications extends NotificationCenter1 {

	private String Message;
	public CustomerNotifications(Communication1 communication, String message) {
		super(communication);
		Message = message;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void notifyMember() {
		notifyCustomer(Message);
		
	}

	

}
