package sits;

import java.util.ArrayList;

public abstract class Participant {
	
	String name;
	ArrayList<State> memory;
	
	abstract int makeChoice(int actions);
	abstract void addMemory(State state);
	abstract void clearMemory();

}
