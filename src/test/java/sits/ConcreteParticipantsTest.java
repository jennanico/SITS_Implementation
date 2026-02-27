package sits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConcreteParticipantsTest {
	
	SelfishBot selfish = new SelfishBot("1");
	SelflessBot selfless = new SelflessBot("2");
	AlternatingBot alternating = new AlternatingBot("3");
	int actions = 1;

	@Test
	void testSelfish() {
		assertEquals(0, selfish.makeChoice(actions));
	}
	
	@Test
	void testSelfless() {
		assertEquals(1, selfless.makeChoice(actions));
	}
	
	@Test
	void testAlternating() {
		assertEquals(1, alternating.makeChoice(actions));
		assertEquals(0, alternating.makeChoice(actions));
		assertEquals(1, alternating.makeChoice(actions));
		assertEquals(0, alternating.makeChoice(actions));



	}

}
