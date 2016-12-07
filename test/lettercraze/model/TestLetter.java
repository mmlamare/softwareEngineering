package lettercraze.model;

import junit.framework.TestCase;
import lettercraze.model.Letter;

public class TestLetter extends TestCase {
	
	@SuppressWarnings("static-access")
	public void testLetter(){
		Letter letter = new Letter();
		char c = letter.genChar();
		assertTrue(letter.getScore(c) > 0 && letter.getScore(c) < 9);
	}
}
