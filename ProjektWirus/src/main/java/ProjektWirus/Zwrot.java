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
			    String str = "Wyniki poprzedniej symulacji:\r\nNajwięcej zarażonych jednego dnia:"+mostSickDay+"\r\nNajwięcej zarażonych w jednym momencie:"+MostSick+"\r\nDzień zakończenia symulacji:"+dayExit;
			    BufferedWriter writer = new BufferedWriter(new FileWriter("Zwrot.txt"));
			    writer.write(str);
			    writer.close();
			}

}
