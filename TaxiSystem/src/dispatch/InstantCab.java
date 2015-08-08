package dispatch;

import java.util.ArrayList;

public class InstantCab extends VehicleType{
	
	public InstantCab(Algorithm a)
	{
		super(a);
	}
	
	public ArrayList callAlgorithm(ArrayList a)
	{
		return callAlgorithm1(a);
	}

}
