package dispatch;

import java.util.ArrayList;

import members.Driver;
import bookings.Request;

public class Algorithm1 extends Algorithm {
	
	public ArrayList callAlgorithm1(ArrayList a){
	//public static void main(String []args){
        
		ArrayList driverInfoFinal=new ArrayList();
        ArrayList driverInfo=(ArrayList)a.get(1);
        Request request=(Request)a.get(0);
		
		
		int r1=request.getPickX();
		int r2=request.getPickY();
		
		for(int i=0;i<driverInfo.size();i++)
		{
			
			Driver mediate=(Driver)driverInfo.get(i);
			int d1=mediate.getCurrent_latitude();
			int d2=mediate.getCurrent_longitude();
			int distance=(int)Math.sqrt(  ((d1-r1)*(d1-r1))    +       ((d2-r2)*(d2-r2))   );
			mediate.setDistance(distance);
		}
		//System.out.println("driverInfo  "+driverInfo);
		for(int i=0;i<15;i++)
		{
		    for(int j=0;j<driverInfo.size();j++)
		    {
		    	Driver mediate=(Driver)driverInfo.get(j);
			    int d1=mediate.getDistance();
			
			  if(d1>=i && d1<(i+1))
			  driverInfoFinal.add(mediate);
			
		    }
		}
		//System.out.println("driverInfoFinal  "+driverInfoFinal);
		return driverInfoFinal;
     }
	
	

}
