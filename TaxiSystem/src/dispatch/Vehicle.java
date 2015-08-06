package dispatch;

import java.util.ArrayList;

public abstract class Vehicle {
	
	protected Algorithm algorithm;
	public abstract ArrayList callAlgorithm(ArrayList a);
	
	public Vehicle(Algorithm a)
	{
		algorithm=a;
	}
	 
	protected ArrayList callAlgorithm1(ArrayList a)
	{
		return algorithm.callAlgorithm1(a);
	}
	

}

