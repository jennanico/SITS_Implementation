package sits;

import java.util.ArrayList;

public abstract class Bracket {
	
	/*
	 * Bracket class for SITS program.
	 * Provides abstract call signature for an algorithm which determines the bracket structure of a tournament.
	 */
		
	abstract Tuple nextPair(ArrayList<TourneyPlayer> participantList, State endState);

}
