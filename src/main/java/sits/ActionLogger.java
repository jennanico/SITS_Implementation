package sits;

import java.io.FileWriter;
import java.io.IOException;

public class ActionLogger extends Observer {

	@Override
	public void update() {
		Game gameSubject = (Game) subject;
		writeToFile("gameActionsLog.txt", gameSubject);
	}
	
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
	
	public void clearCache() {
		try (FileWriter file = new FileWriter("gameActionsLog.txt")) 
		{
		} catch (IOException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}

}
