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
		
		Tuple pair = bracketType.nextPair(scoreboard, game.currState);
		
		while (pair != null) {
			game.play(pair.first.player, pair.second.player);
			
			// Update memory
			pair.first.playersPlayed.add(pair.second);
			pair.second.playersPlayed.add(pair.first);
			
			// Update scoreboard
			pair.first.totalScore += game.currState.p1Score;
			pair.second.totalScore += game.currState.p2Score;
			
			pair = bracketType.nextPair(scoreboard, game.currState);
		}
		
		
		
	}

	

}
