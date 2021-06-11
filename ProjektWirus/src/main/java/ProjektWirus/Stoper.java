package ProjektWirus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Stoper {
	public static Random rand= new Random();
	public static int flaga=100;
	public static int infected;		//dwa atrybuty potrzebne do wyników zwrotnych symulacji
	public static int infectedDay;	//
	public static void routine(ArrayList<Agent> points, ArrayList<AgentPodrozujacy> pointsm,Virus virus,VirusSmiertelny virusDeadly,Szczepionka vaccine) throws IOException
	{
		infectedDay=0;
		if(flaga%100==0)//warunek mijania dnia w symulacji
		{
			infected=0;
			Menu.parametry.setDay(Menu.parametry.getDay()+1);
			for(Agent point: points) //pêtla rutynowa agentów
			{
				switch(point.infected) {
				  case 1://zara¿eni wirusem 1
					 point.daysinfected++;
		         	 point.Checkinfection();
		         	 infectedDay+=Virus.Infection(points,pointsm,vaccine,point,virus.virusInfectionProc);
		         	 infected++;
		         	 break;
				  case 2://zara¿eni wirusem œmiertelnym
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
			for(AgentPodrozujacy point: pointsm) //pêtla rutynowa agentów podró¿uj¹cych
			{
				switch(point.infected) {
				  case 1://zara¿eni wirusem 1
					  point.daysinfected++;
		         	  point.Checkinfection();
		         	  infectedDay+=Virus.Infection(points,pointsm,vaccine,point,virus.virusInfectionProc);
				      infected++;
		         	  break;
				  case 2://zara¿eni wirusem œmiertelnym
					  point.daysinfected++;
		         	  point.Checkinfection();
		         	  infectedDay+=VirusSmiertelny.Infection(points,pointsm,vaccine,point,virus.virusInfectionProc);
		         	  if(rand.nextInt(101)<=point.daysinfected) //szansa œmierci agenta jest funkcj¹ liniow¹ zale¿n¹ od d³ugoœci zara¿enia gdzie jeden dzieñ zara¿enia odpowiada jednemu punktowi procentowemu szansy œmierci na wirusa
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
			if(point.infected!=3) //gdy nie s¹ martwi
			{
				point.Move();//ruch wszystkich agentów podró¿uj¹cych (nie martwych)
			}
		}
		if(Zwrot.MostSick<infected) {Zwrot.MostSick=infected;}//parametry zwrotne
		if(Zwrot.mostSickDay<infectedDay) {Zwrot.mostSickDay=infectedDay;}
		if(infected==0) //Jeden z warunków koñca symulacji
		{
			Zwrot.dayExit=Menu.parametry.getDay();
			Zwrot.toFile();
			JOptionPane.showMessageDialog(null,"Symulacja zakoñczona.\r\nWyniki poprzedniej symulacji:\r\nNajwiêcej zara¿onych jednego dnia:"+Zwrot.mostSickDay+"\r\nNajwiêcej zara¿onych w jednym momencie:"+Zwrot.MostSick+"\r\nDzieñ zakoñczenia symulacji:"+Zwrot.dayExit,"",JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
		}
	}
}
