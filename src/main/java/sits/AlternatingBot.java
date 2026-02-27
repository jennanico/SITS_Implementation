package sits;

public class AlternatingBot extends Participant {

	public AlternatingBot(String name) {
		super(name);
	}

	int lastChoice = 0;
	
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
