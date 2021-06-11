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
				{Zwrot.whyEnd="Doj�cie do maksymalnego czasu trwania symulacji";}
				else
				{Zwrot.whyEnd="Brak zara�onych agent�w na planszy";}
			    String str = "Parametry poprzedniej symulacji:\r\nLiczba ludzi:"+Zwrot.numAgents+"\r\nProcent poruszaj�cych si�:"+Zwrot.procMoving+"\r\nProcent zara�onych:"+Zwrot.procSick+"\r\nProcent zaszczepionych:"+Zwrot.procVacc+"\r\nMaksymalna liczba dni:"+Zwrot.dayEnd+"\r\nWyniki poprzedniej symulacji:\r\nPow�d zako�czenia symulacji:"+Zwrot.whyEnd+"\r\nNajwi�cej zara�onych jednego dnia:"+mostSickDay+"\r\nNajwi�cej zara�onych w jednym momencie:"+MostSick+"\r\nDzie� zako�czenia symulacji:"+dayExit;
			    BufferedWriter writer = new BufferedWriter(new FileWriter("Zwrot.txt"));
			    writer.write(str);
			    writer.close();
			}

}
