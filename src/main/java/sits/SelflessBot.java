package sits;

public class SelflessBot extends Participant {

	// 1 = silence
	@Override
	int makeChoice(int actions) {
		return 1;
	}

}
