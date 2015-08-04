package notifications;

public abstract class NotificationCenter {

	public abstract void notifyCustomer(int id, String message);

	public abstract void notifyDriver(int id, String message);

}
