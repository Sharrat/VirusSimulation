
package ProjektWirus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgentPodrozujacyTest 
{

	    private AgentPodrozujacy agentp;

	    @BeforeEach                                         
	    public void setUp() throws Exception {
	        agentp = new AgentPodrozujacy(0, 1, 2, 3, false);
	    }

	    @Test                                               
	    @DisplayName("Test przypisywania atrybutów przez konstruktor")   
	    public void testConstructor() {
	        assertEquals(0,agentp.x,"konstruktor nieodpowiednio przypisuje atrybuty");            
	    }

	    @Test                                    
	    @DisplayName("Test funkcji Checkinfection()")
	    public void testCheckinfection() {
	       agentp.daysinfected=3;
	       agentp.Checkinfection();
	       assertEquals(0, agentp.infected,"Funkcja sprawdzania zara¿enia powinna zwróciæ 0");
	    }
	    
	    @RepeatedTest(10)                                    
	    @DisplayName("Testy odpychania agentów od granic symulacji przy u¿yciu funkcji Move()")
	    public void testMoveBoundry() {
	    	agentp.x=600;
	    	agentp.y=600;
	    	agentp.Move();
	    	assertEquals(599,agentp.x,"Funkcja Move() niepoprawnie odpycha agentów od granic symulacji");
	    	assertEquals(599,agentp.y,"Funkcja Move() niepoprawnie odpycha agentów od granic symulacji");
	    }
	    @RepeatedTest(10)                                    
	    @DisplayName("Testy u¿ycia funkcji Move()")
	    public void testMove() {
	    	agentp.x=300;
	    	agentp.y=300;
	    	agentp.Move();
	    	assertTrue("Funkcja Move() niepoprawnie losuje kierunek ruchu",agentp.x==301||agentp.x==299||agentp.x==300);
	    	assertTrue("Funkcja Move() niepoprawnie losuje kierunek ruchu",agentp.y==301||agentp.y==299||agentp.y==300);
	    }

}