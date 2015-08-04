package policies;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class DispatchRules extends Rule{

	@Override
	public void setProposedRule(){

		String rule = null;
		System.out.println("Enter Dispatch rule description");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try{
			rule = input.readLine();
			if(rule.isEmpty()){
				System.out.println("Please enter description");
				setProposedRule();

			}
			else{
				setRuleDescription(rule);
				Random rand = new Random();
				setRuleId(rand.nextInt(100));
			}
		}
		catch(Exception e){
			System.out.println("Error in recording rule");


		}
	}



	@Override
	public boolean makeCorrections(){
		String rule = null;
		String answer = null;
		System.out.println("Do you want to make corrections to the proposed dispatch rule?");
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
	public void addCorrections(){
		String rule = null;
		System.out.println("Enter modified rule");
		BufferedReader inputRule = new BufferedReader(new InputStreamReader(System.in));
		try{
			rule = inputRule.readLine();
			if (rule!=null){
				setRuleDescription(rule);
				System.out.println("Rule has been modified");
			}}

		catch(Exception e){
			System.out.println("Error in recording rule");
		}

	}

}
