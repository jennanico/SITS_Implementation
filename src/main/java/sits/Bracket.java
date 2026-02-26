package sits;

import java.util.ArrayList;

public abstract class Bracket {
	
	ArrayList<TourneyPlayer> participantList;
	
	abstract  Tuple nextPair(State endState);

}
