package notifications;

public abstract class NotificationCenter1 {

	protected Communication1 communication;

	public abstract void notifyMember();

	public NotificationCenter1(Communication1 communication) {
		this.communication = communication;
	}
	

	protected void notifyCustomer(String message) {
		this.communication.notifyCustomer( message);
	}

	protected void notifyDriver( String message) {
		this.communication.notifyDriver( message);
	}

}
