package sits;

public class SelfishBot extends Participant {

	public SelfishBot(String name) {
		super(name);
	}

	// 0 = testify
	@Override
	int makeChoice(int actions) {
		return 0;
	}

}
