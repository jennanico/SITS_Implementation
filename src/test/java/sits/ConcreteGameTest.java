package sits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcreteGameTest {
	
	SelfishBot bot1 = new SelfishBot("1");
	SelflessBot bo2 = new SelflessBot("2");
	IteratedPrisonersDilemma IPD = new IteratedPrisonersDilemma(5);

	@Test
	void testEndConditions() {
		IPD.play(bot1, bo2);
		assertEquals(5, IPD.roundsTaken);
	}
	
	@Test
	void testScoreActions() {

		fail("Not yet implemented");
	}
	
	@Test
	void testPlay() {

		fail("Not yet implemented");
	}
	

}
