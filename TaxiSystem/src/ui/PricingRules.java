package ui;

import java.util.HashMap;


/*
 * Singleton Pattern for set of rules 
 */
public class PricingRules {

	private static PricingRules pricingRules;
	private HashMap<String, Pricing> rules = new HashMap<String, Pricing>();

	private PricingRules() {
		rules.put("instantcab", new Pricing(2, 3));
		rules.put("luxurycab", new Pricing(3, 5));
		rules.put("taxi", new Pricing(1, 2));
	}

	public static PricingRules getRules() {
		if (pricingRules == null) {
			pricingRules = new PricingRules();
		}
		return pricingRules;
	}

}
