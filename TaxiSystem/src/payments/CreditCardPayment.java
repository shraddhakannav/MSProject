package payments;

import java.sql.Date;

public class CreditCardPayment implements PaymentStrategy {

	private String name;
	private double cardNumber;
	private int cvv;
	private Date dateOfExpiry;

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid with credit/debit card.");
	}

	public String notifySettlement() {
		String message = "Thanks for your payment! Your Credit Card is accepted.";
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
