package sits;

import java.util.ArrayList;

public abstract class Bracket {
		
	abstract Tuple nextPair(ArrayList<TourneyPlayer> participantList, State endState);

}
