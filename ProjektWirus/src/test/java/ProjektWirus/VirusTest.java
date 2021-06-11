package ProjektWirus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

class VirusTest {

	private Agent agent = new Agent(5, 5, 1, 0, false);
	private ArrayList<Agent> points = new ArrayList<Agent>();
	private ArrayList<AgentPodrozujacy> pointsm = new ArrayList<AgentPodrozujacy>();
	private Szczepionka vaccine = new Szczepionka(0);
	private Virus virus= new Virus(100);
	@Test
	@DisplayName("Test funkcji zara�ania agent�w")
	public void testInfection() 
	{
		points.add(new Agent(5, 5, 0, 0, false));
		pointsm.add(new AgentPodrozujacy(20,20,0,0,false));
		Virus.Infection(points, pointsm, vaccine, agent, virus.virusInfectionProc);
		assertEquals(1,points.get(0).infected,"Agent powinien by� zara�ony!");
		assertEquals(1,points.get(0).daysinfected,"Agent powinien by� zara�ony od jednego dnia!");
		assertEquals(0,pointsm.get(0).infected,"Agent nie powinien by� zara�ony!");
		assertEquals(0,pointsm.get(0).daysinfected,"Agent powinien mie� wyzerowany licznik d�ugo�ci zara�enia!");
	} 

}
