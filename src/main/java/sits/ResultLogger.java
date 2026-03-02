package sits;

import java.io.FileWriter;
import java.io.IOException;

public class ResultLogger extends Observer {

	@Override
	void update() {
		Game gameSubject = (Game) subject;
		writeToFile("gameResultsLog.txt", gameSubject);
	}
	
	public void writeToFile(String fileName, Game gameSubject) {
		
		try (FileWriter file = new FileWriter(fileName, true)) {
			
			if (gameSubject.endGame()) {
				
				file.write("\n\nGame Results - P1: " + gameSubject.currState.p1Name + " vs. P2: " + gameSubject.currState.p2Name);
				file.write("\nP1 Score: " + gameSubject.currState.p1Score + " | P2 score: " + gameSubject.currState.p2Score);
				
			}
			
		} catch (IOException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}
	
	public void clearCache() {
		try (FileWriter file = new FileWriter("gameResultsLog.txt")) 
		{
		} catch (IOException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}

}
