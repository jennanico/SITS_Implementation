package sits;

import java.util.ArrayList;

public abstract class Participant {
	
	/*
	 * Participant class for the SITS program.
	 * Provides an abstract framework for robotic agents who make decisions based off previously observed game states.
	 * Subclasses must specify decision-making behavior.
	 */
	
	String name;
	ArrayList<State> memory;
	
	/*
	 * Constructor.
	 */
	public Participant(String name) {
		this.name = name;
		this.memory = new ArrayList<>();
	}
	
	/*
	 * Add memory state.
	 * @param state		state to be added to memory
	 */
	public void addMemory(State state) {
		memory.add(state);
	}
	
	/*
	 * Clear memory.
	 */
	public void clearMemory() {
		memory.clear();
	}
	
	
	abstract int makeChoice(int actions);


}
