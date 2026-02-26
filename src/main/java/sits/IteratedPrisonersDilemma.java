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
		// TODO Auto-generated method stub
		
		// LOGIC:
		// If one player testifies while the other stays silent, subtract 3 from silent player's score.
		// If both players testify against each other, subtract 2 from players' scores.
		// If neither player testify, subtract 1 from players' scores.
		
		// 0 = testify
		// 1 = stay silent

	}

	@Override
	void notification() {
		// TODO Auto-generated method stub
	}

}
