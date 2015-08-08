package payments;

public class CashPayment implements PaymentStrategy {

	public void pay(int amount) {
		System.out.println("$"+amount + " paid with cash");
	}

	public String notifySettlement() {
		String message = "Thanks for your payment! Cash has been received.";
		System.out.println(message);
		return message;
	}

	@Override
	public void addExchangeRate() {
		String message = "Exchange rates may apply if you are doing transaction outside USA.";
		System.out.println(message);
	}

	@Override
	public void convertCurrency() {
		String message = "Converted charges to $ from Local Currency with FX rates.";
		System.out.println(message);
	}
}
