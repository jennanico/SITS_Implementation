package sits;

public class SelfishBot extends Participant {
	
	/*
	 * Sample Participant for IPD.
	 * Always chooses the "testify" action (i.e., 0).
	 */

	
	/*
	 * Constructor.
	 */
	public SelfishBot(String name) {
		super(name);
	}

	/*
	 * Behavior; returns 1.
	 * @param actions		amount of actions to choose from
	 */
	@Override
	int makeChoice(int actions) {
		return 0;
	}

}
