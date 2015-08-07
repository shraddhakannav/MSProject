package policies;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import ui.MainStart;
import ui.Pricing;
import bookings.DataAccess;

public class PaymentRules extends Rule{

	@Override
	public void setProposedRule() {

		String rule = null;

		Pricing pricing = new Pricing();
		System.out.println("You can add Pricing rules for new cab types here");
		pricing = rulesForm();
		new DataAccess().insertPricingRules(pricing);

	}

	@Override
	public boolean needRevision(){
		String rule = null;
		String answer = null;
		System.out.println("Do you want to make corrections to the proposed payment rule?");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try{
			answer = input.readLine();
			if(answer.toLowerCase().startsWith("y")){
				rulesForm();
				return true;
			}

		}
		catch(Exception e){
			System.out.println("Error in receiving input");


		}
		return false;
	}

	@Override
	public void reviseRule(){
		System.out.println("Payment rules have been revised");
	}


	public Pricing rulesForm(){

		System.out.println("Select Cab type:  1. Taxi 2.Instant 3. Luxury");
		Pricing p = new Pricing();
		try{
			String input;
			input = MainStart.getReader().readLine();
			int cabtype= Integer.parseInt(input);
			switch (cabtype) {
			case 0:
				break;
			case 1:
				p.setCabType("taxi");

				break;
			case 2:
				p.setCabType("instant");
				break;
			case 3:
				p.setCabType("luxury");
				break;

			}
			System.out.println("Set Price: 1.Normal Hour rate/mile  2.Peak Hour rate/mile");
			input = MainStart.getReader().readLine();
			int priceType= Integer.parseInt(input);
			int newprice = 0;
			switch (priceType) {
			case 0:
				break;
			case 1:
				System.out.println("Enter Normal Hour rate/mile:");
				newprice = Integer.parseInt(input);
				p.setNormalRate(newprice);
				break;
			case 2:
				System.out.println("Enter Peak Hour rate/mile:");
				newprice = Integer.parseInt(input);
				p.setPeakRate(newprice);
				break;

			}

			System.out.println("Rule has been created");
		}
		catch(Exception e){
			System.out.println("Error in recording rule");


		}
		return p;

	}
	@Override
	public void updateRules(){
		System.out.println("Update Pricing Rules");
		Pricing pricing = rulesForm();
		new DataAccess().updatePricingRules(pricing);


	}

}






