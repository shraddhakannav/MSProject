package notifications;

public class DriverNotifications extends NotificationCenter1{

	private String Message;
	public DriverNotifications(Communication1 communication, String message) {
		super(communication);
		Message = message;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void notifyMember() {
		notifyDriver(Message);
		
	}


}
