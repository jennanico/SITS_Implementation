package sits;

public abstract class Game extends Subject {
	
	/*
	 * Game class for the SITS program.
	 * Provides an abstract framework for a 2-player, decision based game.
	 * Subclasses must specify game scoring logic & end conditions.
	 */
	
	int actions;		// amount of available actions to choose from
	State currState;	// current state of the game
	int roundsTaken;
	
	
	/*
	 * Core algorithm for playing a game. Until the end conditions are met, allow players to make decisions each round.
	 * 
	 * @param player1		player 1 participant.
	 * @param player2		player 2 participant.
	 */
	public State play(Participant player1, Participant player2) {
		
		// First, reset counters/state variables
		roundsTaken = 0;
		
		currState.p1Name = player1.name;
		currState.p2Name = player2.name;
		currState.p1Score = 0;
		currState.p2Score = 0;
		
		// Main loop
		while (!endGame()) {
			
			currState.p1Action = player1.makeChoice(actions);
			currState.p2Action = player2.makeChoice(actions);
			
			scoreActions(currState.p1Action, currState.p2Action);
			
			player1.addMemory(currState);
			player2.addMemory(currState);
			
			handleCustomCode();	// Hook function, such as for listeners
			
			roundsTaken++;
			
		}
		
	    handleCustomCode();	// Second hook opportunity

		return currState;	
	}
	
	
	// Hook function, deliberately empty
	public void handleCustomCode() {
		
	}
	
	
	abstract boolean endGame();
	abstract void scoreActions(int player1Action, int player2Action);
 
}
