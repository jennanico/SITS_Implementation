package sits;

import java.util.ArrayList;

public abstract class Bracket {
	
	// TODO change back to tourneyplayer
	ArrayList<Participant> participantList;
	
	abstract  Tuple nextPair(State endState);

}
