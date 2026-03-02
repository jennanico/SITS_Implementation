package sits;

import java.util.ArrayList;

public class IteratedPrisonersDilemma extends Game {
	
	/*
	 * IteratedPrisonerDilemma class for SITS program.
	 * Implements the iterated prisoner's dilemma game, wherein a maximum round constraint can be specified.
	 * Also a subject which can support observers--ActionLogger and ResultsLogger.
	 */
	
	int maxRounds;	// max rounds to elapse before game concludes
	
	/*
	 * Constructor.
	 */
	public IteratedPrisonersDilemma(int maxRounds) {
		this.actions = 1;
		this.currState = new State();
		this.roundsTaken = 0;
		this.maxRounds = maxRounds;
		
		this.listeners = new ArrayList<>();
	}

	/*
	 * Determines if the game is over yet.
	 */
	boolean endGame() {
		if (roundsTaken >= maxRounds) {
			return true;
		}
		
		return false;
	}

	
	/*
	 * Scores the actions of the players.
	 * 	// LOGIC:
		// If one player testifies while the other stays silent, subtract 3 from silent player's score.
		// If both players testify against each other, subtract 2 from players' scores.
		// If neither player testify (i.e., both stay silent), subtract 1 from players' scores.
		
		// 0 = testify
		// 1 = stay silent
		
		@param player1Action	action that Player 1 selected
		@param player2Action	action that Player 2 selected
	 */
	void scoreActions(int player1Action, int player2Action) {		
		
		// Bad input
		if ( !((player1Action == 1 || player1Action == 0) && (player2Action == 1 || player2Action == 0)) ) {
			return;
		}
		
		
		// Check cases and modify score accordingly:
		if (player1Action == 0 && player2Action == 1) 
		{
			currState.p2Score -= 3;
		}
		else if (player1Action == 1 && player2Action == 0) 
		{
			currState.p1Score -= 3;
		}
		else if (player1Action == 0 && player2Action == 0) 
		{
			currState.p1Score -= 2;
			currState.p2Score -= 2;
		}
		else if (player1Action == 1 && player2Action == 1) 
		{
			currState.p1Score -= 1;
			currState.p2Score -= 1;
		}
		
	}

	
	/*
	 * Override hook() function to notify listeners within the inherited play() algorithm.
	 */
	@Override
	public void hook() {
		notification();
	}

	
	/*
	 * Notification function; notifies all observers.
	 */
	@Override
	void notification() {
		for (Observer listener : listeners) {
			listener.update();
		}
	}
	

}
