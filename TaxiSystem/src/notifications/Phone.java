package notifications;

public class Phone extends Communication {

	int id;
	int phone;

	public Phone(NotificationCenter notification, int id, int phone) {
		super(notification);
		this.phone = phone;
		this.id = id;
	}

	@Override
	public void notifyMember() {
		notifyCustomers(id, "Calling to Customer " + id);
		notifyDrivers(id, "Calling to Driver " + id);
		System.out.println("Calling on phone: '" + phone + "' to Customer and Driver"
				+ id);
	}

}
