package sits;

import java.util.ArrayList;

public class RoundRobinBracket extends Bracket {
	
	/*
	 * RoundRobinBracket class for SITS program.
	 * Implements a round robin style bracket.
	 */
	
	int counter1; 		// two counters that cycle through the list of participants
	int counter2;
	
	/*
	 * Constructor.
	 */
	public RoundRobinBracket() {
		this.counter1 = 0;
		this.counter2 = 0;
	}

	/*
	 * Core algorithm. Manually indexes through the list of participants so that each player plays each other once.
	 * @param participantList		roster of players, generally Tournament.scoreboard
	 * @param endState				results state of the most recently concluded game
	 */
	@Override
	Tuple nextPair(ArrayList<TourneyPlayer> participantList, State endState) {
		Tuple pair = new Tuple();
		
		counter2++;
		
		// If counter2 exceeds, reset & increment counter1
		if (counter2 >= participantList.size()) {
			counter2 = 0;
			counter1++;
		}
		
		// If counter1 exceeds, finished
		if (counter1 >= participantList.size() - 1) {
			return null;
		}
		
		// Do not let player play themselves, or previously played players
		while (counter2 <= counter1) {
			counter2++;
		}
		
		// Otherwise, proceed
		pair.first = participantList.get(counter1);
		pair.second = participantList.get(counter2);
		
		return pair;
		
	}
	

}
