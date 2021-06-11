package ProjektWirus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Stoper {
	public static Random rand= new Random();
	public static int flaga=100;
	public static int infected;		//dwa atrybuty potrzebne do wynik�w zwrotnych symulacji
	public static int infectedDay;	//
	public static void routine(ArrayList<Agent> points, ArrayList<AgentPodrozujacy> pointsm,Virus virus,VirusSmiertelny virusDeadly,Szczepionka vaccine) throws IOException
	{
		infectedDay=0;
		if(flaga%100==0)//warunek mijania dnia w symulacji
		{
			infected=0;
			Menu.parametry.setDay(Menu.parametry.getDay()+1);
			for(Agent point: points) //p�tla rutynowa agent�w
			{
				switch(point.infected) {
				  case 1://zara�eni wirusem 1
					 point.daysinfected++;
		         	 point.Checkinfection();
		         	 infectedDay+=Virus.Infection(points,pointsm,vaccine,point,virus.virusInfectionProc);
		         	 infected++;
		         	 break;
				  case 2://zara�eni wirusem �miertelnym
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
			for(AgentPodrozujacy point: pointsm) //p�tla rutynowa agent�w podr�uj�cych
			{
				switch(point.infected) {
				  case 1://zara�eni wirusem 1
					  point.daysinfected++;
		         	  point.Checkinfection();
		         	  infectedDay+=Virus.Infection(points,pointsm,vaccine,point,virus.virusInfectionProc);
				      infected++;
		         	  break;
				  case 2://zara�eni wirusem �miertelnym
					  point.daysinfected++;
		         	  point.Checkinfection();
		         	  infectedDay+=VirusSmiertelny.Infection(points,pointsm,vaccine,point,virus.virusInfectionProc);
		         	  if(rand.nextInt(101)<=point.daysinfected) //szansa �mierci agenta jest funkcj� liniow� zale�n� od d�ugo�ci zara�enia gdzie jeden dzie� zara�enia odpowiada jednemu punktowi procentowemu szansy �mierci na wirusa
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
			if(point.infected!=3) //gdy nie s� martwi
			{
				point.Move();//ruch wszystkich agent�w podr�uj�cych (nie martwych)
			}
		}
		if(Zwrot.MostSick<infected) {Zwrot.MostSick=infected;}//parametry zwrotne
		if(Zwrot.mostSickDay<infectedDay) {Zwrot.mostSickDay=infectedDay;}
		if(infected==0) //Jeden z warunk�w ko�ca symulacji
		{
			Zwrot.dayExit=Menu.parametry.getDay();
			Zwrot.toFile();
			JOptionPane.showMessageDialog(null,"Symulacja zako�czona.\r\nWyniki poprzedniej symulacji:\r\nNajwi�cej zara�onych jednego dnia:"+Zwrot.mostSickDay+"\r\nNajwi�cej zara�onych w jednym momencie:"+Zwrot.MostSick+"\r\nDzie� zako�czenia symulacji:"+Zwrot.dayExit,"",JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
		}
	}
}
