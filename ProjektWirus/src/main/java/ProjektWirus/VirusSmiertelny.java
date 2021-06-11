package ProjektWirus;

import java.util.ArrayList;

public class VirusSmiertelny extends Virus{

	public VirusSmiertelny(int x) {
		super(x);
	}
	public static int Infection(ArrayList<Agent> points, ArrayList<AgentPodrozujacy> pointsm,Szczepionka vaccine,Agent point,int viruschance)//funkcja rutynowego zara�ania si� agent�w, zwraca ile ten agent w danym momencie zarazi� innych agent�w 
	{
		int infected=0;
		if(Stoper.rand.nextInt(101)>=(101-viruschance))//losowa szansa zara�enia (z uwzgl�dnieniem zarazliwo�ci wirusa)
		{ 
     	   for(Agent pkt: points)//wszyscy agenci
  		   {
     		   if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)//sprawdzanie czy odleg�o�� jest odpowiednia
			   {
				   if(pkt.infected==0) //kt�rzy nie s� zara�eni
				   {
					   if(pkt.vaccinated==true) //je�eli s� zaszczepieni
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
     		   if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)//sprawdzanie czy odleg�o�� jest odpowiednia
			   {
				   if(pkt.infected==0) //kt�rzy nie s� zara�eni
				   {
					   if(pkt.vaccinated==true) //je�eli s� zaszczepieni
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
	public static int Infection(ArrayList<Agent> points, ArrayList<AgentPodrozujacy> pointsm,Szczepionka vaccine,AgentPodrozujacy point,int viruschance) //funkcja rutynowego zara�ania si� agent�w, zwraca ile ten agent w danym momencie zarazi� innych agent�w 
	{
		int infected=0;
		if(Stoper.rand.nextInt(101)>=(101-viruschance))//losowa szansa zara�enia (z uwzgl�dnieniem zarazliwo�ci wirusa)
		{ 
     	   for(Agent pkt: points)//wszyscy agenci
  		   {
     		   if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)//sprawdzanie czy odleg�o�� jest odpowiednia
			   {
				   if(pkt.infected==0) //kt�rzy nie s� zara�eni
				   {
					   if(pkt.vaccinated==true) //je�eli s� zaszczepieni
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
     		   if(Math.abs(pkt.x-point.x)<=5&&Math.abs(pkt.y-point.y)<=5)//sprawdzanie czy odleg�o�� jest odpowiednia
			   {
				   if(pkt.infected==0) //kt�rzy nie s� zara�eni
				   {
					   if(pkt.vaccinated==true) //je�eli s� zaszczepieni
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
	
	public static void die(Agent x) //funkcja zabijaj�ca agenta
	{
		x.infected=3;
	}
	
	public static void die(AgentPodrozujacy x) //funkcja zabijaj�ca agenta podr�uj�cego
	{
		x.infected=3;
	}
}
