package dispatch;

import java.util.ArrayList;

public class Taxi extends VehicleType{
	
	public Taxi(Algorithm a)
	{
		super(a);
	}
	
	public ArrayList callAlgorithm(ArrayList a)
	{
		return callAlgorithm1(a);
	}

}