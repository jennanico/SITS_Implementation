package sits;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcreteTournamentTest {
	
	SelfishBot SB1 = new SelfishBot();
	SelfishBot SB2 = new SelfishBot();
	SelflessBot LB1 = new SelflessBot();
	SelflessBot LB2 = new SelflessBot();
	AlternatingBot AB1 = new AlternatingBot();
	AlternatingBot AB2 = new AlternatingBot();
	
	RoundRobinBracket roundrobin = new RoundRobinBracket();
	IteratedPrisonersDilemma IPD = new IteratedPrisonersDilemma();
	
	Tournament tourney;

	@BeforeEach
	void setUp() throws Exception {
		tourney = new Tournament(IPD, roundrobin);
		
		tourney.registerPlayer(SB1);
		tourney.registerPlayer(SB2);
		tourney.registerPlayer(LB1);
		tourney.registerPlayer(LB2);
		tourney.registerPlayer(AB1);
		tourney.registerPlayer(AB2);
		
	}

	@Test
	void testTournAttsSet() {

		fail("Not yet implemented");
	}
	
	@Test
	void testPlayersRegistered() {

		fail("Not yet implemented");
	}
	
	@Test
	void testBracketNextPair() {

		fail("Not yet implemented");
	}
	
	@Test
	void testScoresUpdate() {

		fail("Not yet implemented");
	}
	
	
}
