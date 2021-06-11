package ProjektWirus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgentTest 
{

	    private Agent agent;

	    @BeforeEach                                         
	    public void setUp() throws Exception {
	        agent = new Agent(0, 1, 2, 3, false);
	    }

	    @Test                                               
	    @DisplayName("Test przypisywania atrybutów przez konstruktor")   
	    public void testConstructor() {
	        assertEquals(0,agent.x,"konstruktor nieodpowiednio przypisuje atrybuty");            
	    }

	    @Test                                    
	    @DisplayName("Test funkcji Checkinfection()")
	    public void testCheckinfection() {
	       agent.daysinfected=3;
	       agent.Checkinfection();
	       assertEquals(0, agent.infected,"Funkcja sprawdzania zara¿enia powinna zwróciæ 0");
	    }
	

}
