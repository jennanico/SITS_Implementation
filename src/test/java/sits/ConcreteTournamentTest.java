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
				
		ArrayList<Participant> players = new ArrayList<>();
		players.add(bot1);
		players.add(bot2);
		players.add(bot3);
		players.add(bot4);
		players.add(bot5);
		
		RoundRobinBracket roundrobin = new RoundRobinBracket(null);

		Tournament tourney = new Tournament(players, null, roundrobin);
		
		roundrobin.participantList = tourney.scoreboard;
		
		State state = new State();
		
		Tuple pair;
		pair = tourney.bracketType.nextPair(state);
		state.p1Name = "bob";
		state.p2Name = "bobby";
		while (pair != null) {
			pair = tourney.bracketType.nextPair(state);
		}

		
	}

}
