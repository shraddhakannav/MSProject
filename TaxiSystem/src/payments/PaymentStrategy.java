package payments;

public interface PaymentStrategy {

	public void pay(int amount);

	public String notifySettlement();

	public void addExchangeRate();

	public void convertCurrency();

}
