package ProjektWirus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VirusSmiertelnyTest {
	Agent agent = new Agent(0, 0, 2, 0, false);
	@Test
	@DisplayName("Test funkcji zabijania agentów")
	public void testDie() 
	{
		VirusSmiertelny.die(agent);
		assertEquals(3,agent.infected,"Wartoœæ pola infected powinna wynosiæ 3 (martwy)");
	}

}
