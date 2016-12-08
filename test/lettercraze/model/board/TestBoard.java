package lettercraze.model.board;

import junit.framework.TestCase;

public class TestBoard extends TestCase {
	
	public void testBoard(){
		Board b = new Board();
		Point p = new Point(0, 0);
		Point q = new Point(3, 5);
		
		assertTrue(b.isEmpty(p));
		assertTrue(b.isEmpty(q));
		
		assertTrue(b.clone().isEmpty(p));
		
		b.floatLetters();
	}
}
