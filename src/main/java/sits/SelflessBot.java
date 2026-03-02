package sits;

public class SelflessBot extends Participant {
	
	/*
	 * Sample Participant for IPD.
	 * Always chooses the "silence" action (i.e., 1).
	 */

	
	/*
	 * Constructor.
	 */
	public SelflessBot(String name) {
		super(name);
	}

	/*
	 * Behavior; returns 1.
	 * @param actions		amount of actions to choose from
	 */
	@Override
	int makeChoice(int actions) {
		return 1;
	}

}
