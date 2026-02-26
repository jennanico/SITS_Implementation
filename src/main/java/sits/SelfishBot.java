package sits;

public class SelfishBot extends Participant {

	// 0 = selfish
	@Override
	int makeChoice(int actions) {
		return 0;
	}

}
