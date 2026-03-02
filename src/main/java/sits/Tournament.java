package sits;

import java.util.ArrayList;

public class Tournament {
	
	/*
	 * Tournament class for the SITS program.
	 * Facilitates an environment where players can compete in a repeated competitive environment.
	 */
	
	ArrayList<TourneyPlayer> scoreboard;	// roster of players
	Game game;								// game to be played
	Bracket bracketType;					// type of tournament bracket
	
	/*
	 * Constructor.
	 */
	public Tournament(ArrayList<TourneyPlayer> scoreboard, Game game, Bracket bracketType) {
		this.scoreboard = scoreboard;
		this.game = game;
		this.bracketType = bracketType;
	}
	
	/*
	 * Constructor option 2.
	 */
	public Tournament(Game game, Bracket bracketType) {
		this.scoreboard = new ArrayList<>();
		this.game = game;
		this.bracketType = bracketType;
	}
	
	/*
	 * Type converter--register a Participant into a TourneyPlayer.
	 * @param player		Participant to be registered
	 */
	public void registerPlayer(Participant player) {
		
		// Ensure not adding a player already present in the scoreboard
		for (TourneyPlayer currPlayer : scoreboard) {
			if (currPlayer.player == player) {
				return;
			}
		}
		
		TourneyPlayer newPlayer = new TourneyPlayer(player);
		scoreboard.add(newPlayer);
	}
	
	/*
	 * Core algorithm that allows players to play against each other as the bracket progresses.
	 */
	public void playTournament() {
		
		// Obtain the first pairing
		Tuple pair = bracketType.nextPair(scoreboard, game.currState);
		
		// Move through the bracket until no pairings are left
		while (pair != null) {
			
			game.play(pair.first.player, pair.second.player);
			
			// Update memory
			pair.first.playersPlayed.add(pair.second);
			pair.second.playersPlayed.add(pair.first);
			
			// Update scoreboard
			pair.first.totalScore += game.currState.p1Score;
			pair.second.totalScore += game.currState.p2Score;
			
			// Next pair
			pair = bracketType.nextPair(scoreboard, game.currState);
		}
			
	}
	

}
