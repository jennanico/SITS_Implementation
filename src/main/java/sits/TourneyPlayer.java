package sits;

import java.util.ArrayList;

public class TourneyPlayer {
	
	Participant player;
	int totalScore;
	ArrayList<TourneyPlayer> playersPlayed;
	
	public TourneyPlayer(Participant player) {
		this.player = player;
		this.totalScore = 0;
		this.playersPlayed = new ArrayList<>();
	}

}
