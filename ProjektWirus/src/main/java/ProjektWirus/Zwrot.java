package ProjektWirus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Zwrot {
	public static int MostSick;//najwi�cej zara�onych w jednym momencie
	public static int dayExit;//dzie� zako�czenia symulacji
	public static int mostSickDay;//najwi�cej zara�onych w jednym dniu
	private static int numAgents;// liczba agent�w
	private static int procMoving; // procent poruszaj�cych si�
	private static int procSick;// procent zara�onych
	private static int procVacc;// procent zaszczepionych
	private static int dayEnd;// maksymalna d�ugo�� trwania symulacji
	private static String whyEnd;//warunek ko�ca symulacji
	public Zwrot(int x,int y, int z,int a, int b) //pobranie parametr�w symulacji
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
				if(dayExit==dayEnd) //sprawdzenie warunku ko�ca symulacji
				{Zwrot.whyEnd="Doj�cie do maksymalnego czasu trwania symulacji";}
				else
				{Zwrot.whyEnd="Brak zara�onych agent�w na planszy";}
			    String str = "Parametry poprzedniej symulacji:\r\nLiczba ludzi:"+Zwrot.numAgents+"\r\nProcent poruszaj�cych si�:"+Zwrot.procMoving+"\r\nProcent zara�onych:"+Zwrot.procSick+"\r\nProcent zaszczepionych:"+Zwrot.procVacc+"\r\nMaksymalna liczba dni:"+Zwrot.dayEnd+"\r\nWyniki poprzedniej symulacji:\r\nPow�d zako�czenia symulacji:"+Zwrot.whyEnd+"\r\nNajwi�cej zara�onych jednego dnia:"+mostSickDay+"\r\nNajwi�cej zara�onych w jednym momencie:"+MostSick+"\r\nDzie� zako�czenia symulacji:"+dayExit;
			    BufferedWriter writer = new BufferedWriter(new FileWriter("Zwrot.txt"));//writer tworz�cy i wpisuj�cy do pliku zwrot symulacji
			    writer.write(str);
			    writer.close();
			}

}
