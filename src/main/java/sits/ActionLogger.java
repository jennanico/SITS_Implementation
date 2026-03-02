package sits;

import java.io.FileWriter;
import java.io.IOException;

public class ActionLogger extends Observer {

	/*
	 * ActionLogger class for SITS program.
	 * An observer that logs every agent action inside an IPD game.
	 */

	
	/*
	 * Update method.
	 * Delegates to writeToFile() after typecasting subject.
	 */
	
	@Override
	public void update() {
		Game gameSubject = (Game) subject;
		writeToFile("gameActionsLog.txt", gameSubject);
	}
	
	
	/*
	 * Writes game results to file.
	 * @param fileName		file name to be written in
	 * @gameSubject			observer subject, i.e., the game whose actions are being recorded
	 */
	public void writeToFile(String fileName, Game gameSubject) {
		
		try (FileWriter file = new FileWriter(fileName, true)) {
			
			if (gameSubject.roundsTaken == 0) {
				file.write("\n\nP1: " + gameSubject.currState.p1Name + " vs. P2: " + gameSubject.currState.p2Name);
			}
			
			file.write("\n " + gameSubject.currState.p1Action + " | " + gameSubject.currState.p2Action);
			
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
