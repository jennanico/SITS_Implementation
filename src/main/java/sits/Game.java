package sits;

public abstract class Game extends Subject {
	
	int actions;
	State currState;
	int roundsTaken;
	
	public State play(Participant player1, Participant player2) {
		
		currState.p1Name = player1.name;
		currState.p2Name = player2.name;
		
		while (!endGame()) {
			
			currState.p1Action = player1.makeChoice(actions);
			currState.p2Action = player2.makeChoice(actions);
			
			scoreActions(currState.p1Action, currState.p2Action);
			
			player1.addMemory(currState);
			player2.addMemory(currState);
			
			hook1();
			
			roundsTaken++;
			
		}
		
	    hook2();

		return currState;	
	}
	
	public void hook1() {
		
	}
	
	public void hook2() {
		
	}
	
	abstract boolean endGame();
	abstract void scoreActions(int player1Action, int player2Action);
 
}
