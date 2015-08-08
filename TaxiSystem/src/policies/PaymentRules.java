package policies;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import ui.MainStart;
import ui.Pricing;
import bookings.DataAccess;

// Priya's version
public class PaymentRules extends Rule{


	@Override
	public void setProposedRule() {

		String rule = null;

		Pricing pricing = new Pricing();
		System.out.println("You can add Pricing rules for new cab types here");
		pricing = rulesForm();
		new DataAccess().insertPricingRules(pricing);
		System.out.println("Rule has proposed");
		
		

	}

	@Override
	public boolean needRevision(){
		String rule = null;
		String answer = null;
		System.out.println("Do you want to revise the proposed payment rule?");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try{
			answer = input.readLine();
			if(answer.toLowerCase().startsWith("y")){
				
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
		updateRules();
			}


	public Pricing rulesForm(){

	//	System.out.println("Select Cab type:  1. Taxi 2.InstantCab");
		System.out.println("Enter cab type");
		Pricing p = new Pricing();
		try{
			String input;
			input = MainStart.getReader().readLine();
//			int cabtype= Integer.parseInt(input);
//			int sub_type;
//			switch (cabtype) {
//			case 0:
//				break;
//			case 1:
				p.setCabType(input);
				System.out.println("Enter sub type");
				input = MainStart.getReader().readLine();
				//sub_type= Integer.parseInt(input);
				
				p.setSubType(input);
//				if(sub_type==1)
//				{
//					p.setSubType("basic");
//					}
//				else
//				{
//					p.setSubType("luxury");
//					
//				}
				
//				break;
//			case 2:
//				p.setCabType("instantcab");
//				System.out.println("Select Sub type:  1. Basic 2.Luxury");
//				input = MainStart.getReader().readLine();
//				sub_type= Integer.parseInt(input);
//				if(sub_type==1)
//				{
//					p.setSubType("basic");}
//				else
//				{
//					p.setSubType("luxury");
//				}
//				break;*/
			
				
//			

			
	
			System.out.println("Enter normal hour rate/mile");
			input = MainStart.getReader().readLine();
//			int priceType= Integer.parseInt(input);
			int newprice = 0;
//			switch (priceType) {
//			case 0:
//				break;
//			case 1:
//				System.out.println("Enter Normal Hour rate/mile:");
				newprice = Integer.parseInt(input);
				p.setNormalRate(newprice);
				//break;
		//	case 2:
				System.out.println("Enter Peak Hour rate/mile:");
				input = MainStart.getReader().readLine();
				newprice = Integer.parseInt(input);
				p.setPeakRate(newprice);
//				break;
//
//			}

			
		}
		catch(Exception e){
			System.out.println("Error in recording rule");


		}
		return p;

	}
	@Override
	public void updateRules(){
	
	
		System.out.println("Update Pricing Rules");
		
		Pricing pricing = updaterulesForm();
		new DataAccess().updatePricingRules(pricing);


	}

	private Pricing updaterulesForm() {
		
		Pricing p = new Pricing();
		try {
			
		
			String cartype = null, subtype=null;
			
			System.out.println();
			System.out
					.println("___________________________________________________________________");
			System.out.println("Rule update form");
			System.out
					.println("___________________________________________________________________");
			System.out.println("Please enter values for fields to update: ");
			String input = "";
			System.out.println("Enter Car Type:  " );
			input = MainStart.getReader().readLine();		
			
			cartype = input;
			
			System.out.println("Enter Car Sub Type:  " );
			input = MainStart.getReader().readLine();		
			
			subtype = input;
			
			
			 p = new DataAccess().retreivePricing(cartype, subtype);
			
			
			System.out.println("Normal rate:  " + p.getNormalRate()+" :"); 
			
			input = MainStart.getReader().readLine();
			if (!input.trim().isEmpty()){

				p.setNormalRate(Double.parseDouble(input));
				}

			System.out.println("Peak Rate: "+ p.getPeakRate() +" :");
			
			input = MainStart.getReader().readLine();
			if (!input.trim().isEmpty()){
			p.setPeakRate(Double.parseDouble(input));
			}
		
		}
		catch(Exception e){
			System.out.println("Error in updating rule");
		}
		return p;

}
}