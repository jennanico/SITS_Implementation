package sits;

public class IteratedPrisonersDilemma extends Game {

	// Simple end condition of 5 rounds.
	boolean endGame() {
		if (roundsTaken >= 5) {
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
	void notification() {
		// TODO Auto-generated method stub
	}

}
