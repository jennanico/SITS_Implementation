package sits;

public class AlternatingBot extends Participant {
	
	/*
	 * Sample Participant for IPD.
	 * Always alternates choices, i.e., flips between 0 and 1.
	 */

	int lastChoice = 0;		// previously selected action
	
	/*
	 * Constructor.
	 */
	public AlternatingBot(String name) {
		super(name);
	}

	
	/*
	 * Behavior; alternates between 0 and 1.
	 * @param actions		amount of actions to choose from
	 */
	@Override
	int makeChoice(int actions) {
		if (lastChoice == 0) {
			lastChoice = 1;
		}
		else {
			lastChoice = 0;
		}
		return lastChoice;
	}
	

}
