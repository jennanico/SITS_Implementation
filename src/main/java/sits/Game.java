package sits;

public abstract class Game extends Subject {
	
	int actions;
	State currState;
	int roundsTaken;
	
	public State play(Participant player1, Participant player2) {
		
		roundsTaken = 0;
		
		currState.p1Name = player1.name;
		currState.p2Name = player2.name;
		currState.p1Score = 0;
		currState.p2Score = 0;
		
		while (!endGame()) {
			
			currState.p1Action = player1.makeChoice(actions);
			currState.p2Action = player2.makeChoice(actions);
			
			scoreActions(currState.p1Action, currState.p2Action);
			
			player1.addMemory(currState);
			player2.addMemory(currState);
			
			hook();
			
			roundsTaken++;
			
		}
		
	    hook();

		return currState;	
	}
	
	public void hook() {
		
	}
	
	
	abstract boolean endGame();
	abstract void scoreActions(int player1Action, int player2Action);
 
}
