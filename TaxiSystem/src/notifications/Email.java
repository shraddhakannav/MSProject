package notifications;

public class Email extends Communication {

	int id;
	String message;

	public Email(NotificationCenter notification, int custId, String message) {
		super(notification);
		this.id = custId;
		this.message = message;
	}

	@Override
	public void notifyMember() {
		// TODO Auto-generated method stub
		notifyCustomers(id, message);
		System.out.println("Sending Email: '" + message + "' to Customer" + id);
	}

}
