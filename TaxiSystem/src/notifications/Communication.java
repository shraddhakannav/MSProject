package notifications;

public abstract class Communication {

	protected NotificationCenter notification;

	public abstract void notifyMember();

	public Communication(NotificationCenter notification) {
		this.notification = notification;
	}

	protected void notifyCustomers(int id, String message) {
		this.notification.notifyCustomer(id, message);
	}

	protected void notifyDrivers(int id, String message) {
		this.notification.notifyDriver(id, message);
	}

}
