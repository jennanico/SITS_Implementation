package sits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcreteTournamentTest {
	
	SelfishBot SB1 = new SelfishBot("1");
	SelfishBot SB2 = new SelfishBot("2");
	SelflessBot LB1 = new SelflessBot("3");
	SelflessBot LB2 = new SelflessBot("4");
	AlternatingBot AB1 = new AlternatingBot("5");
	AlternatingBot AB2 = new AlternatingBot("6");
	
	RoundRobinBracket roundrobin = new RoundRobinBracket();
	IteratedPrisonersDilemma IPD = new IteratedPrisonersDilemma(5);
	
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
		assertEquals(roundrobin, tourney.bracketType);
		assertEquals(IPD, tourney.game);
	}
	
	@Test
	void testRegisterPlayer() {
		assertEquals(6, tourney.scoreboard.size());
		
		assertFalse(tourney.scoreboard.contains(SB1));
		
		TourneyPlayer tp = tourney.scoreboard.get(0);
		assertEquals(SB1, tp.player);
		assertEquals(0, tp.totalScore);
		assertEquals(0, tp.playersPlayed.size());
	}
	
	
	@Test
	void testBadInputRegisterPlayer() {
		assertEquals(6, tourney.scoreboard.size());
		tourney.registerPlayer(AB2);
		assertEquals(6, tourney.scoreboard.size());
	}
	
	
	@Test
	void testBracketNextPair() {
		
		Tuple pair = tourney.bracketType.nextPair(tourney.scoreboard, tourney.game.currState);
		
		while (pair != null) {
			
			assertTrue(pair.first != pair.second);
			assertTrue(!pair.first.playersPlayed.contains(pair.second));
			assertTrue(!pair.second.playersPlayed.contains(pair.first));
			
			pair = tourney.bracketType.nextPair(tourney.scoreboard, tourney.game.currState);
		}
		
		assertNull(tourney.bracketType.nextPair(tourney.scoreboard, tourney.game.currState));
		
	}
	
	@Test
	void testScoresUpdate() {
		
		tourney.playTournament();
		assertEquals(-18, tourney.scoreboard.get(0).totalScore);
		assertEquals(-22, tourney.scoreboard.get(1).totalScore);
		assertEquals(-53, tourney.scoreboard.get(2).totalScore);
		assertEquals(-57, tourney.scoreboard.get(3).totalScore);
		assertEquals(-37, tourney.scoreboard.get(4).totalScore);
		assertEquals(-37, tourney.scoreboard.get(5).totalScore);

	}
	
	
}
