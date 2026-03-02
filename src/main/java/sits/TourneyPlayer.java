package sits;

import java.util.ArrayList;

public class TourneyPlayer {
	
	/*
	 * TourneyPlayer class for SITS program.
	 * Represents a Participant registered to play in a tournament.
	 */
	
	Participant player;
	int totalScore;								// accumulated score within tournament
	ArrayList<TourneyPlayer> playersPlayed;		// list of players previously played
	
	/*
	 * Constructor.
	 */
	public TourneyPlayer(Participant player) {
		this.player = player;
		this.totalScore = 0;
		this.playersPlayed = new ArrayList<>();
	}

}
