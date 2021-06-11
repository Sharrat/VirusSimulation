package ProjektWirus;

import java.util.ArrayList;

public class VirusSmiertelny extends Virus{

	public VirusSmiertelny(int x) {
		super(x);
	}
	public static int Infection(ArrayList<Agent> points, ArrayList<AgentPodrozujacy> pointsm,Szczepionka vaccine,Agent point,int viruschance)//funkcja rutynowego zara¿ania siê agentów, zwraca ile ten agent w danym momencie zarazi³ innych agentów 
	{
		int infected=0;
		if(Stoper.rand.nextInt(101)>=(101-viruschance))//losowa szansa zara¿enia (z uwzglêdnieniem zarazliwoœci wirusa)
		{ 
     	   for(Agent pkt: points)//wszyscy agenci
  		   {
     		   if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)//sprawdzanie czy odleg³oœæ jest odpowiednia
			   {
				   if(pkt.infected==0) //którzy nie s¹ zara¿eni
				   {
					   if(pkt.vaccinated==true) //je¿eli s¹ zaszczepieni
					   {
						   if(Stoper.rand.nextInt(101)>=vaccine.getVaccEfficiency()) //sprawdzanie czy szczepionka chroni przed wirusem
						   {
		  					   pkt.infected=2;
		  					   pkt.daysinfected=1;
		  					   infected++;	   
						   }
					   }
					   else 
					   {
						   pkt.infected=2;
						   pkt.daysinfected=1;
						   infected++;
					   }
				   }
			   }
  		   }
  		   for(AgentPodrozujacy pkt: pointsm) 
  		   {
     		   if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)//sprawdzanie czy odleg³oœæ jest odpowiednia
			   {
				   if(pkt.infected==0) //którzy nie s¹ zara¿eni
				   {
					   if(pkt.vaccinated==true) //je¿eli s¹ zaszczepieni
					   {
						   if(Stoper.rand.nextInt(101)>=vaccine.getVaccEfficiency()) //sprawdzanie czy szczepionka chroni przed wirusem
						   {
		  					   pkt.infected=2;
		  					   pkt.daysinfected=1;
		  					   infected++;	   
						   }
					   }
					   else 
					   {
						   pkt.infected=2;
						   pkt.daysinfected=1;
						   infected++;
					   }
				   }
			   }
  		   }
        }
		return infected;
	}
	public static int Infection(ArrayList<Agent> points, ArrayList<AgentPodrozujacy> pointsm,Szczepionka vaccine,AgentPodrozujacy point,int viruschance) //funkcja rutynowego zara¿ania siê agentów, zwraca ile ten agent w danym momencie zarazi³ innych agentów 
	{
		int infected=0;
		if(Stoper.rand.nextInt(101)>=(101-viruschance))//losowa szansa zara¿enia (z uwzglêdnieniem zarazliwoœci wirusa)
		{ 
     	   for(Agent pkt: points)//wszyscy agenci
  		   {
     		   if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)//sprawdzanie czy odleg³oœæ jest odpowiednia
			   {
				   if(pkt.infected==0) //którzy nie s¹ zara¿eni
				   {
					   if(pkt.vaccinated==true) //je¿eli s¹ zaszczepieni
					   {
						   if(Stoper.rand.nextInt(101)>=vaccine.getVaccEfficiency()) //sprawdzanie czy szczepionka chroni przed wirusem
						   {
		  					   pkt.infected=2;
		  					   pkt.daysinfected=1;
		  					   infected++;	   
						   }
					   }
					   else 
					   {
						   pkt.infected=2;
						   pkt.daysinfected=1;
						   infected++;
					   }
				   }
			   }
  		   }
  		   for(AgentPodrozujacy pkt: pointsm) 
  		   {
     		   if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)//sprawdzanie czy odleg³oœæ jest odpowiednia
			   {
				   if(pkt.infected==0) //którzy nie s¹ zara¿eni
				   {
					   if(pkt.vaccinated==true) //je¿eli s¹ zaszczepieni
					   {
						   if(Stoper.rand.nextInt(101)>=vaccine.getVaccEfficiency()) //sprawdzanie czy szczepionka chroni przed wirusem
						   {
		  					   pkt.infected=2;
		  					   pkt.daysinfected=1;
		  					   infected++;	   
						   }
					   }
					   else 
					   {
						   pkt.infected=2;
						   pkt.daysinfected=1;
						   infected++;
					   }
				   }
			   }
  		   }
        }
		return infected;
	}
	
	public static void die(Agent x) //funkcja zabijaj¹ca agenta
	{
		x.infected=3;
	}
	
	public static void die(AgentPodrozujacy x) //funkcja zabijaj¹ca agenta podró¿uj¹cego
	{
		x.infected=3;
	}
}
