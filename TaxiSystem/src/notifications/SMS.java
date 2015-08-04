package notifications;

public class SMS extends Communication {

	int id;
	String message;

	public SMS(NotificationCenter notification, int custId, String message) {
		super(notification);
		this.id = custId;
		this.message = message;
	}

	@Override
	public void notifyMember() {
		// TODO Auto-generated method stub
		notifyCustomers(id, message);
		System.out.println("Sending SMS: '" + message + "' to Customer" + id);
	}

}
