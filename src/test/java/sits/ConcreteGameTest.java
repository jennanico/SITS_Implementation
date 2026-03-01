package sits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcreteGameTest {
	
	SelfishBot bot1 = new SelfishBot("1");
	SelflessBot bot2 = new SelflessBot("2");
	IteratedPrisonersDilemma IPD = new IteratedPrisonersDilemma(5);

	@Test
	void testEndConditions() {
		IPD.roundsTaken = 5;
		assertTrue(IPD.endGame());
		
		IPD.roundsTaken = 4;
		assertFalse(IPD.endGame());
	}
	
	@Test
	void testScoreActions() {
		
		IPD.scoreActions(0, 1);
		assertEquals(0, IPD.currState.p1Score);
		assertEquals(-3, IPD.currState.p2Score);
		
		IPD.scoreActions(1, 0);
		assertEquals(-3, IPD.currState.p1Score);
		assertEquals(-3, IPD.currState.p2Score);
		
		IPD.scoreActions(0, 0);
		assertEquals(-5, IPD.currState.p1Score);
		assertEquals(-5, IPD.currState.p2Score);
		
		IPD.scoreActions(1, 1);
		assertEquals(-6, IPD.currState.p1Score);
		assertEquals(-6, IPD.currState.p2Score);

	}
	
	@Test
	void testBadInputScoreActions() {
		IPD.scoreActions(2, 3);
		assertTrue(IPD.currState.p1Score == 0 && IPD.currState.p2Score == 0);
		
		IPD.scoreActions(1, 3);
		assertTrue(IPD.currState.p1Score == 0 && IPD.currState.p2Score == 0);
		
		IPD.scoreActions(2, 0);
		assertTrue(IPD.currState.p1Score == 0 && IPD.currState.p2Score == 0);
	}
	
	@Test
	void testPlay() {
		IPD.play(bot1, bot2);
		
		assertEquals("1", IPD.currState.p1Name);
		assertEquals(0, IPD.currState.p1Action);
		assertEquals(0, IPD.currState.p1Score);
		
		assertEquals("2", IPD.currState.p2Name);
		assertEquals(1, IPD.currState.p2Action);
		assertEquals(-15, IPD.currState.p2Score);
		
		assertEquals(5, IPD.roundsTaken);
		
	}
	

}
