package sits;

public class SelflessBot extends Participant {

	public SelflessBot(String name) {
		super(name);
	}

	// 1 = silence
	@Override
	int makeChoice(int actions) {
		return 1;
	}

}
