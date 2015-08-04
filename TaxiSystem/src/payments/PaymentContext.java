package payments;

public class PaymentContext {

	private PaymentStrategy ps;

	public void pay(PaymentType type, int amount) {
		ps = setPaymentStrategy(type);
		ps.pay(amount);
	}

	public PaymentStrategy setPaymentStrategy(PaymentType n) {
		if (PaymentType.CASH == n) {
			ps = new CashPayment();
		} else if (PaymentType.CREDITCARD == n) {
			ps = new CreditCardPayment();
		} else if (PaymentType.PAYPAL == n) {
			ps = new Paypal();
		}
		return ps;
	}
}
