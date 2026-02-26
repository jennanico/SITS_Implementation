package sits;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcreteTournamentTest {


	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testRoundRobin() {
		SelfishBot bot1 = new SelfishBot();
		SelfishBot bot2 = new SelfishBot();
		SelfishBot bot3 = new SelfishBot();
		SelfishBot bot4 = new SelfishBot();
		SelfishBot bot5 = new SelfishBot();
		
		RoundRobinBracket roundrobin = new RoundRobinBracket();

		Tournament tourney = new Tournament(null, roundrobin);

		tourney.registerPlayer(bot1);
		tourney.registerPlayer(bot2);
		tourney.registerPlayer(bot3);
		tourney.registerPlayer(bot4);
		tourney.registerPlayer(bot5);
		
		State state = new State();		
		Tuple pair = new Tuple();
		
		while (pair != null) {
			pair = tourney.bracketType.nextPair(tourney.scoreboard, state);
		}

		
	}

}
