package sits;

import java.util.ArrayList;

public class IteratedPrisonersDilemma extends Game {
	
	int maxRounds;
	
	public IteratedPrisonersDilemma(int maxRounds) {
		this.actions = 1;
		this.currState = new State();
		this.roundsTaken = 0;
		this.maxRounds = maxRounds;
		
		this.listeners = new ArrayList();
	}

	// Simple end condition of 5 rounds.
	boolean endGame() {
		if (roundsTaken >= maxRounds) {
			return true;
		}
		
		return false;
	}

	void scoreActions(int player1Action, int player2Action) {		
		// LOGIC:
		// If one player testifies while the other stays silent, subtract 3 from silent player's score.
		// If both players testify against each other, subtract 2 from players' scores.
		// If neither player testify (i.e., both stay silent), subtract 1 from players' scores.
		
		// 0 = testify
		// 1 = stay silent
		
		
		// Bad input
		if ( !((player1Action == 1 || player1Action == 0) && (player2Action == 1 || player2Action == 0)) ) {
			return;
		}
		
		
		// Case one
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

	@Override
	public void hook() {
		notification();
	}

	@Override
	void notification() {
		for (Observer listener : listeners) {
			listener.update();
		}
	}
	

}
