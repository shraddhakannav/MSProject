package dispatch;

import java.util.ArrayList;

public abstract class VehicleType {
	
	protected Algorithm algorithm;
	public abstract ArrayList callAlgorithm(ArrayList a);
	
	public VehicleType(Algorithm a)
	{
		algorithm=a;
	}
	 
	protected ArrayList callAlgorithm1(ArrayList a)
	{
		return algorithm.callAlgorithm1(a);
	}
	

}

