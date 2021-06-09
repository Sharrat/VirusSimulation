package ProjektWirus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Stoper {
	public static Random rand= new Random();
	public static int flaga=100;
	public static int infected;
	public static int infectedDay;
	public static void routine(ArrayList<Agent> points, ArrayList<AgentPodrozujacy> pointsm,Virus virus,VirusSmiertelny virusDeadly,Szczepionka vaccine) throws IOException
	{
		infected=0;
		infectedDay=0;
		if(flaga%100==0) 
		{
			Menu.parametry.setDay(Menu.parametry.getDay()+1);
			for(Agent point: points) 
			{
				switch(point.infected) {
				  case 1:
					 point.daysinfected++;
		         	 point.Checkinfection();
		         	 infectedDay+=Virus.Infection(points,pointsm,vaccine,point,virus.virusInfectionProc);
		         	 infected++;
		         	 break;
				  case 2:
					  point.daysinfected++;
		         	  point.Checkinfection();
		         	  infectedDay+=VirusSmiertelny.Infection(points,pointsm,vaccine,point,virus.virusInfectionProc);
		         	  if(rand.nextInt(101)<=point.daysinfected) 
		         	  {
		         		  VirusSmiertelny.die(point);
		         	  }
		         	  infected++;
					break;  
				}
			}
			for(AgentPodrozujacy point: pointsm) 
			{
				switch(point.infected) {
				  case 1:
					  point.daysinfected++;
		         	  point.Checkinfection();
		         	  infectedDay+=Virus.Infection(points,pointsm,vaccine,point,virus.virusInfectionProc);
				      infected++;
		         	  break;
				  case 2:
					  point.daysinfected++;
		         	  point.Checkinfection();
		         	  infectedDay+=VirusSmiertelny.Infection(points,pointsm,vaccine,point,virus.virusInfectionProc);
		         	  if(rand.nextInt(101)<=point.daysinfected) 
		         	  {
		         		  VirusSmiertelny.die(point);
		         	  }
		         	  infected++;
					break;
				}
			}
		}
		flaga++;
		for(AgentPodrozujacy point:pointsm) 
		{
			if(point.infected!=3) 
			{
				point.Move();
			}
		}
		if(Zwrot.MostSick<infected) {Zwrot.MostSick=infected;}
		if(Zwrot.mostSickDay<infectedDay) {Zwrot.mostSickDay=infectedDay;}
		if(Menu.parametry.getDay()==Menu.parametry.getDayEnd()||infected==0) 
		{
			Zwrot.dayExit=Menu.parametry.getDay();
			Zwrot.toFile();
		}
	}
}
