package sits;

import java.io.FileWriter;
import java.io.IOException;

public class ResultLogger extends Observer {
	
	/*
	 * ResultLogger class for SITS program.
	 * An observer that logs the results of an IPD game.
	 */

	
	/*
	 * Update method.
	 * Delegates to writeToFile() after typecasting subject.
	 */
	@Override
	void update() {
		Game gameSubject = (Game) subject;
		writeToFile("gameResultsLog.txt", gameSubject);
	}
	
	
	/*
	 * Writes game results to file.
	 * @param fileName		file name to be written in
	 * @gameSubject			observer subject, i.e., the just-concluded game being recorded
	 */
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
	
	
	/*
	 * Clear file contents.
	 * @param fileName		file to clear
	 */
	public void clearCache(String fileName) {
		try (FileWriter file = new FileWriter(fileName)) 
		{
		} catch (IOException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}
	

}
