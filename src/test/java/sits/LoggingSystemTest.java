package sits;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.assertj.core.util.Files;
import org.codehaus.plexus.util.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoggingSystemTest {
	
	IteratedPrisonersDilemma IPD = new IteratedPrisonersDilemma(5);
	
	ActionLogger gameLogger = new ActionLogger();
	ResultLogger resultLogger = new ResultLogger();
	
	SelfishBot bot1 = new SelfishBot("1");
	SelflessBot bot2 = new SelflessBot("2");

	@BeforeEach
	void setUp() throws Exception {		
		IPD.register(gameLogger);
		IPD.register(resultLogger);
	}

	@Test
	void testRegisterListener() {
		assertTrue(IPD.listeners.contains(gameLogger));
		assertTrue(IPD.listeners.contains(resultLogger));

	}
	
	@Test
	void testDeregisterListener() {
		IPD.deregister(gameLogger);
		IPD.deregister(resultLogger);
		assertFalse(IPD.listeners.contains(gameLogger));
		assertFalse(IPD.listeners.contains(resultLogger));
	}
	
	@Test
	void testClearCache() {
		gameLogger.clearCache();
		resultLogger.clearCache();
		
		File file = new File("gameActionsLog.txt");
		File file2 = new File("gameResultsLog.txt");
		assertTrue(file.exists());
		assertTrue(file2.exists());
		
		String fileContent = Files.contentOf(file, StandardCharsets.UTF_8);
		assertTrue(fileContent.contains(""));

		String fileContent2 = Files.contentOf(file2, StandardCharsets.UTF_8);
		assertTrue(fileContent2.contains(""));
	}
	
	@Test
	void testUpdateActionLogger() {
		gameLogger.clearCache();
		
		IPD.play(bot1, bot2);
		
		File file = new File("gameActionsLog.txt");
		assertTrue(file.exists());
		
		String fileContent = Files.contentOf(file, StandardCharsets.UTF_8);
		
		assertTrue(fileContent.contains("P1: 1 vs. P2: 2"));
		assertTrue(fileContent.contains("0 | 1"));		
	}
	
	@Test
	void testUpdateResultLogger() {
		resultLogger.clearCache();
		
		IPD.play(bot1, bot2);
		
		File file = new File("gameResultsLog.txt");
		assertTrue(file.exists());
		
		String fileContent = Files.contentOf(file, StandardCharsets.UTF_8);
		
		assertTrue(fileContent.contains("Game Results"));
		assertTrue(fileContent.contains("P1 Score: 0 | P2 score: -15"));
	}
	
	@Test
	void testTournamentLogging() {
		gameLogger.clearCache();
		resultLogger.clearCache();
		
		RoundRobinBracket roundrobin = new RoundRobinBracket();
		Tournament tourney = new Tournament(IPD, roundrobin);
		tourney.registerPlayer(new SelfishBot("1"));
		tourney.registerPlayer(new SelfishBot("2"));
		tourney.registerPlayer(new SelfishBot("3"));
		tourney.playTournament();
		
		File file = new File("gameActionsLog.txt");
		File file2 = new File("gameResultsLog.txt");
		assertTrue(file.exists());
		assertTrue(file2.exists());
		
		String fileContent = Files.contentOf(file, StandardCharsets.UTF_8);
		int count = StringUtils.countMatches(fileContent, "vs");
		assertEquals(3, count);
		
		String fileContent2 = Files.contentOf(file2, StandardCharsets.UTF_8);
		count = StringUtils.countMatches(fileContent2, "Results");
		assertEquals(3, count);
	}
	

}
