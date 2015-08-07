package ui;

public class PricingTable {
	String cab_type;
	int normalrate;
	int peakrate;

	public PricingTable(String cab_type, int normalrate, int peakrate) {
		this.cab_type = cab_type;
		this.normalrate = normalrate;
		this.peakrate = peakrate;
	}

}
