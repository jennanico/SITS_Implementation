package sits;

public abstract class Game {
	
	int actions;
	State currState;
	int roundsTaken;
	
	public State play(Participant player1, Participant player2) {
		return currState;	
	}
	
	public void hook1() {
		
	}
	
	public void hook2() {
		
	}
	
	abstract boolean endGame();
	abstract void scoreActions(int player1Action, int player2Action);
 
}
