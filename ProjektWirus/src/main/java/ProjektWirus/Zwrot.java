package ProjektWirus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Zwrot {
	public static int MostSick;
	public static int dayExit;
	public static int mostSickDay;
	public Zwrot() 
	{
		
	}
	public static void toFile() 
			  throws IOException 
			{
			    String str = "Wyniki poprzedniej symulacji:\r\nNajwi�cej zara�onych jednego dnia:"+mostSickDay+"\r\nNajwi�cej zara�onych w jednym momencie:"+MostSick+"\r\nDzie� zako�czenia symulacji:"+dayExit;
			    BufferedWriter writer = new BufferedWriter(new FileWriter("Zwrot.txt"));
			    writer.write(str);
			    writer.close();
			}

}
