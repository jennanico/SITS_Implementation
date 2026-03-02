package sits;

public class Tuple {
	
	/*
	 * Tuple class for SITS program.
	 * Helper class that holds a pair of TourneyPlayers, mainly for the use of Bracket & Tournament.
	 */
	
	public TourneyPlayer first;
	public TourneyPlayer second;
	
	/*
	 * Constructor.
	 */
	public Tuple(TourneyPlayer first, TourneyPlayer second) {
		this.first = first;
		this.second = second;
	}

	/*
	 * Constructor option 2.
	 */
	public Tuple() {

	}

}
