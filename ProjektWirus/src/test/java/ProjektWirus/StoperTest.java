package ProjektWirus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

class StoperTest {
	private ArrayList<Agent> points = new ArrayList<Agent>();
	private ArrayList<AgentPodrozujacy> pointsm = new ArrayList<AgentPodrozujacy>();
	private Szczepionka vaccine = new Szczepionka(0);
	private Virus virus= new Virus(100);
	private VirusSmiertelny viruss= new VirusSmiertelny(100);
	
	
	@Test
	@DisplayName("Test licznika dni")
	public void testFlag() throws IOException 
	{
		for(int i=0;i<100;i++) 
		{
			Stoper.routine(points, pointsm, virus, viruss, vaccine);
		}
		assertEquals(200,Stoper.flaga,"flaga powinna wynosiæ 200!");
	} 
}
