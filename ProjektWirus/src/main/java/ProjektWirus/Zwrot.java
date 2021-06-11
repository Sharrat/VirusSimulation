package ProjektWirus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Zwrot {
	public static int MostSick;
	public static int dayExit;
	public static int mostSickDay;
	private static int numAgents;
	private static int procMoving;
	private static int procSick;
	private static int procVacc;
	private static int dayEnd;
	private static String whyEnd;
	public Zwrot(int x,int y, int z,int a, int b) 
	{
		Zwrot.numAgents=x;
		Zwrot.procMoving=y;
		Zwrot.procSick=z;
		Zwrot.procVacc=a;
		Zwrot.dayEnd=b;
		
	}
	public static void toFile() 
			  throws IOException 
			{
				if(dayExit==dayEnd) 
				{Zwrot.whyEnd="Dojœcie do maksymalnego czasu trwania symulacji";}
				else
				{Zwrot.whyEnd="Brak zara¿onych agentów na planszy";}
			    String str = "Parametry poprzedniej symulacji:\r\nLiczba ludzi:"+Zwrot.numAgents+"\r\nProcent poruszaj¹cych siê:"+Zwrot.procMoving+"\r\nProcent zara¿onych:"+Zwrot.procSick+"\r\nProcent zaszczepionych:"+Zwrot.procVacc+"\r\nMaksymalna liczba dni:"+Zwrot.dayEnd+"\r\nWyniki poprzedniej symulacji:\r\nPowód zakoñczenia symulacji:"+Zwrot.whyEnd+"\r\nNajwiêcej zara¿onych jednego dnia:"+mostSickDay+"\r\nNajwiêcej zara¿onych w jednym momencie:"+MostSick+"\r\nDzieñ zakoñczenia symulacji:"+dayExit;
			    BufferedWriter writer = new BufferedWriter(new FileWriter("Zwrot.txt"));
			    writer.write(str);
			    writer.close();
			}

}
