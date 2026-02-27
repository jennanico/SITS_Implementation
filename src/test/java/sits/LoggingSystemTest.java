package sits;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.assertj.core.util.Files;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoggingSystemTest {
	
	IteratedPrisonersDilemma IPD = new IteratedPrisonersDilemma(5);
	ActionLogger logger = new ActionLogger();
	SelfishBot bot1 = new SelfishBot("1");
	SelflessBot bot2 = new SelflessBot("2");

	@BeforeEach
	void setUp() throws Exception {		
		IPD.register(logger);
	}

	@Test
	void testRegisterListener() {
		fail("Not yet implemented");
	}
	
	@Test
	void testDeregisterListener() {
		fail("Not yet implemented");
	}
	
	@Test
	void testClearCache() {
		logger.clearCache();
		
		File file = new File("gameActionsLog.txt");
		assertTrue(file.exists());
		
		String fileContent = Files.contentOf(file, StandardCharsets.UTF_8);
		assertTrue(fileContent.contains(""));
	}
	
	@Test
	void testUpdateActionLogger() {
		logger.clearCache();
		
		IPD.play(bot1, bot2);
		
		File file = new File("gameActionsLog.txt");
		assertTrue(file.exists());
		
		String fileContent = Files.contentOf(file, StandardCharsets.UTF_8);
		
		assertTrue(fileContent.contains("P1: 1 vs. P2: 2"));
		assertTrue(fileContent.contains("0 | 1"));		
	}


}
