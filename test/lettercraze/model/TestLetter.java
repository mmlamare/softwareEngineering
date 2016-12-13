package lettercraze.model;

import junit.framework.TestCase;
import lettercraze.model.Letter;

public class TestLetter extends TestCase {
	public void testLetter(){
		char c = Letter.genChar();
		assertTrue(Letter.getScore(c) > 0 && Letter.getScore(c) < 9);
	}
}
