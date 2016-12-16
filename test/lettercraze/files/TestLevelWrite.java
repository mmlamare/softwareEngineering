package lettercraze.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import junit.framework.TestCase;
import lettercraze.model.Dictionary;
import lettercraze.model.Level;
import lettercraze.model.LevelType;
import lettercraze.model.board.Board;

public class TestLevelWrite extends TestCase {
	public void testWritingPuzzle() {
		try {
			File testFile = File.createTempFile("lettercraze", ".lvl");
			Level l = new Level();
			l.initBoard = new Board();
			l.limit = 10;
			l.name = "";
			l.oneStar = 1;
			l.twoStar = 2;
			l.threeStar = 3;
			l.type = LevelType.PUZZLE;
			l.words = null;
			assertTrue(LevelWriter.writeLevel(l, testFile));

			Level l2 = new LevelLoader().load(new FileInputStream(testFile));
			assertEquals(l2.limit, 10);
			assertEquals(l2.name, "");
			assertEquals(l2.oneStar, 1);
			assertEquals(l2.twoStar, 2);
			assertEquals(l2.threeStar, 3);
			assertEquals(l2.type, LevelType.PUZZLE);
		} catch (IOException e) {
			System.err.println("This system has no tmp files. There is no God. Abort!");
			e.printStackTrace();
		}
	}
	
	public void testWritingTheme() {
		try {
			File testFile = File.createTempFile("lettercraze", ".lvl");
			Level l = new Level();
			l.initBoard = new Board();
			l.limit = 0;
			l.name = "colors";
			l.oneStar = 1;
			l.twoStar = 2;
			l.threeStar = 3;
			l.type = LevelType.THEME;
			l.words = new Dictionary();
			l.words.addWord("test");
			assertTrue(LevelWriter.writeLevel(l, testFile));

			Level l2 = new LevelLoader().load(new FileInputStream(testFile));
			assertEquals(l2.limit, 0);
			assertEquals(l2.name, "colors");
			assertEquals(l2.oneStar, 1);
			assertEquals(l2.twoStar, 2);
			assertEquals(l2.threeStar, 3);
			assertEquals(l2.type, LevelType.THEME);
			assertEquals(l2.words.getList().size(), 1);
			assertTrue(l2.words.isWord("test"));
		} catch (IOException e) {
			System.err.println("This system has no tmp files. There is no God. Abort!");
			e.printStackTrace();
		}
	}
}
