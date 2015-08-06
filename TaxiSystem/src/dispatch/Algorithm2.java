package dispatch;

import java.util.ArrayList;

public class Algorithm2 extends Algorithm {
	
	public ArrayList callAlgorithm1(ArrayList a)
	{
		

        
        ArrayList driverInfo=new ArrayList();
        ArrayList driverInfoFinal=new ArrayList();
		ArrayList temp=new ArrayList();
		temp.add(1);
		temp.add(1);
		temp.add(1);
		temp.add("1");
		driverInfo.add(temp);
		temp=new ArrayList();
		temp.add(1);
		temp.add(5);
		temp.add(5);
		temp.add("5");
		driverInfo.add(temp);
		temp=new ArrayList();
		temp.add(4);
		temp.add(5);
		temp.add(2);
		temp.add("2");
		driverInfo.add(temp);
		temp=new ArrayList();
		temp.add(1);
		temp.add(5);
		temp.add(3);
		temp.add("3");
		driverInfo.add(temp);
		temp=new ArrayList();
		temp.add(1);
		temp.add(1);
		temp.add(4);
		temp.add("4");
		driverInfo.add(temp);
		ArrayList request=new ArrayList();
		request.add(3);
		request.add(1);
		
		int r1=Integer.parseInt(request.get(0).toString());
		int r2=Integer.parseInt(request.get(0).toString());
		
		for(int i=0;i<driverInfo.size();i++)
		{
			
			ArrayList mediate=(ArrayList)driverInfo.get(i);
			int d1=Integer.parseInt(mediate.get(0).toString());
			int d2=Integer.parseInt(mediate.get(0).toString());
			int distance=(int)Math.sqrt(  ((d1-r1)*(d1-r1))    +       ((d1-r1)*(d1-r1))   );
			mediate.add(distance);
		}
		System.out.println("driverInfo  "+driverInfo);
		for(int i=0;i<15;i++)
		{
		    for(int j=0;j<driverInfo.size();j++)
		    {
		    ArrayList mediate=(ArrayList)driverInfo.get(j);
			int d1=Integer.parseInt(mediate.get(4).toString());
			
			if(d1>=i && d1<(i+1))
			driverInfoFinal.add(mediate);
			
		    }
		}
		System.out.println("driverInfoFinal  "+driverInfoFinal);
		return driverInfoFinal;
     
	}
	
	

}