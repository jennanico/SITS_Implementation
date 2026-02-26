package sits;

import java.util.ArrayList;

public class Tournament {
	
	ArrayList<TourneyPlayer> scoreboard;
	Game game;
	Bracket bracketType;
	
	public void playTournament() {
		
		State currState = new State();
		Tuple pair;
		
		pair = bracketType.nextPair(currState);
		
		while (pair != null) {
			currState = game.play(pair.first, pair.second);
			pair = bracketType.nextPair(currState);
		}
		
		
	}

}
