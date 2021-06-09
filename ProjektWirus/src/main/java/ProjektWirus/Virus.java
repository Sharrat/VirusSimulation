package ProjektWirus;

import java.util.ArrayList;

public class Virus{
	public int virusInfectionProc;
	public Virus(int x) 
	{
		this.virusInfectionProc=x;
	}
	public static int Infection(ArrayList<Agent> points, ArrayList<AgentPodrozujacy> pointsm,Szczepionka vaccine,Agent point,int viruschance) 
	{
		int infected=0;
		if(Stoper.rand.nextInt(101)>=(101-viruschance)) {
     	   for(Agent pkt: points)
  		   {
  			   if(pkt.infected==0) 
  			   {
  				   if(pkt.vaccinated==true) 
  				   {
  					   if(Stoper.rand.nextInt(101)>=vaccine.getVaccEfficiency()) 
  					   {
						   if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)
	  				   	   {
		  					   pkt.infected=1;
		  					   pkt.daysinfected=1;
		  					   infected++;
	  				       } 
  					   }
  				   }
  				   else 
  				   {
  					 if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)
    				   {
    					   pkt.infected=1;
    					   pkt.daysinfected=1;
    					   infected++;
    				   }
  				   }
  				   
  			   }
  		   }
  		   for(AgentPodrozujacy pkt: pointsm) 
  		   {
  			   if(pkt.infected==0) 
  			   {
  				   if(pkt.vaccinated==true) 
  				   {
  					   if(Stoper.rand.nextInt(101)>=vaccine.getVaccEfficiency()) 
  					   {
						   if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)
	  				   	   {
		  					   pkt.infected=1;
		  					   pkt.daysinfected=1;
		  					   infected++;
	  				       } 
  					   }
  				   }
  				   else 
  				   {
  					 if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)
    				   {
    					   pkt.infected=1;
    					   pkt.daysinfected=1;
    					   infected++;
    				   }
  				   }
  				   
  			   }
  		   }
        }
		return infected;
	}
	public static int Infection(ArrayList<Agent> points, ArrayList<AgentPodrozujacy> pointsm,Szczepionka vaccine,AgentPodrozujacy point,int viruschance) 
	{
		int infected=0;
		if(Stoper.rand.nextInt(101)>=(101-viruschance)) {
     	   for(Agent pkt: points)
  		   {
  			   if(pkt.infected==0) 
  			   {
  				   if(pkt.vaccinated==true) 
  				   {
  					   if(Stoper.rand.nextInt(101)>=vaccine.getVaccEfficiency()) 
  					   {
						   if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)
	  				   	   {
		  					   pkt.infected=1;
		  					   pkt.daysinfected=1;
		  					   infected++;
	  				       } 
  					   }
  				   }
  				   else 
  				   {
  					 if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)
    				   {
    					   pkt.infected=1;
    					   pkt.daysinfected=1;
    					   infected++;
    				   }
  				   }
  				   
  			   }
  		   }
  		   for(AgentPodrozujacy pkt: pointsm) 
  		   {
  			   if(pkt.infected==0) 
  			   {
  				   if(pkt.vaccinated==true) 
  				   {
  					   if(Stoper.rand.nextInt(101)>=vaccine.getVaccEfficiency()) 
  					   {
						   if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)
	  				   	   {
		  					   pkt.infected=1;
		  					   pkt.daysinfected=1;
		  					   infected++;
	  				       } 
  					   }
  				   }
  				   else 
  				   {
  					 if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)
    				   {
    					   pkt.infected=1;
    					   pkt.daysinfected=1;
    					   infected++;
    				   }
  				   }
  				   
  			   }
  		   }
        }
		return infected;
	}
}
