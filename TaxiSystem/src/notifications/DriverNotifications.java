package notifications;

public class DriverNotifications extends NotificationCenter{

	@Override
	public void notifyCustomer(int id, String message) {
		System.out.println("Customer " + id + "got notification message: '"
				+ message + "'");
	}

	@Override
	public void notifyDriver(int id, String message) {
		System.out.println("Driver " + id + "got notification message: '"
				+ message + "'");

	}


}
