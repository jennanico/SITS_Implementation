package sits;

import java.util.ArrayList;

public class Tournament {
	
	//TODO change this back to tourneyplayer
	ArrayList<Participant> scoreboard;
	
	Game game;
	Bracket bracketType;
	
	public Tournament(ArrayList<Participant> scoreboard, Game game, Bracket bracketType) {
		super();
		this.scoreboard = scoreboard;
		this.game = game;
		this.bracketType = bracketType;
	}
	
	public void playTournament() {
		
		State currState = new State();
		Tuple pair;
		
		pair = bracketType.nextPair(currState);
		
		
		while (pair != null) {
			currState = game.play(pair.first, pair.second); 		//TODO change back
			pair = bracketType.nextPair(currState);
		}
		
		
	}

	

}
