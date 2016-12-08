package lettercraze.model;

import junit.framework.TestCase;
import lettercraze.model.Dictionary;

public class TestDictionary extends TestCase {
	protected void setUp(){
		
	}
	
	public void testDictionary(){
		Dictionary dic = new Dictionary();
		dic.addWord("dictionary");
		assertTrue(dic.isWord("dictionary"));
		assertFalse(dic.isWord("thing"));
	}
}
