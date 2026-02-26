package sits;

import java.util.ArrayList;

public class RoundRobinBracket extends Bracket {
	
	int counter1;
	int counter2;
	
	public RoundRobinBracket(ArrayList<Participant> participantList) {
		this.participantList = participantList;
		this.counter1 = 0;
		this.counter2 = 0;
	}

	@Override
	Tuple nextPair(State endState) {
		Tuple pair = new Tuple();
		
		counter2++;
		
		// If counter2 exceeds, reset & increment counter1
		if (counter2 >= participantList.size()) {
			counter2 = 0;
			counter1++;
		}
		
		// If counter1 exceeds, finished
		if (counter1 >= participantList.size() - 1) {
			return null;
		}
		
		// Do not let player play themselves, or previously played players
		while (counter2 <= counter1) {
			counter2++;
		}
		
		// Otherwise, proceed
		pair.first = participantList.get(counter1);
		pair.second = participantList.get(counter2);
		
		return pair;
		
	}

}
