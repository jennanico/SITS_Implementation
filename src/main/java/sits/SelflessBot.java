package sits;

public class SelflessBot extends Participant {

	// 1 = cooperate
	@Override
	int makeChoice(int actions) {
		return 1;
	}

}
