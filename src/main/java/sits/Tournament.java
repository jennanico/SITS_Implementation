package sits;

import java.util.ArrayList;

public class Tournament {
	
	ArrayList<TourneyPlayer> scoreboard;
	
	Game game;
	Bracket bracketType;
	
	public Tournament(ArrayList<TourneyPlayer> scoreboard, Game game, Bracket bracketType) {
		this.scoreboard = scoreboard;
		this.game = game;
		this.bracketType = bracketType;
	}
	
	public Tournament(Game game, Bracket bracketType) {
		this.scoreboard = new ArrayList<>();
		this.game = game;
		this.bracketType = bracketType;
	}
	
	// Type converter -- register a Participant into a TourneyPlayer
	public void registerPlayer(Participant player) {
		TourneyPlayer newPlayer = new TourneyPlayer(player);
		scoreboard.add(newPlayer);
	}
	
	// Core algorithm
	public void playTournament() {
		
		State currState = new State();
		Tuple pair = new Tuple();
		
		while (pair != null) {
			currState = game.play(pair.first.player, pair.second.player);
			pair = bracketType.nextPair(scoreboard, currState);
		}
		
		
	}

	

}
