package lettercraze.files;

import static lettercraze.model.LevelType.LIGHTNING;
import static lettercraze.model.LevelType.PUZZLE;
import static lettercraze.model.LevelType.THEME;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import lettercraze.model.Dictionary;
import lettercraze.model.Level;
import lettercraze.model.board.Board;
import lettercraze.model.board.Point;
import lettercraze.model.board.Square;

/**
 * This class handles loading level files
 * @author Ruthenium
 * @version 1.0
 */
public class LevelLoader implements Loader {
	
	public Level load(InputStream in) {
		Scanner sc = new Scanner(in);
		Level result = new Level();

		// The first line is the level type
		String typeStr = sc.nextLine();
		if (typeStr.equals("puzzle")) {
			result.type = PUZZLE;
		} else if (typeStr.equals("theme")) {
			result.type = THEME;
		} else if (typeStr.equals("lightning")) {
			result.type = LIGHTNING;
		} else {
			sc.close();
			return null;
		}
		
		// the second line is always the level name
		result.name = sc.nextLine();

		// The next line is 36 characters describing the initial contents of the board
		result.initBoard = new Board();
		String contents = sc.next(".{36}");
		int idx = 0;
		for (int row=0; row < Board.SIZE; ++row) {
			for (int col=0; col < Board.SIZE; ++col) {
				char ch = contents.charAt(idx);
				switch (ch) {
				case '.':
					result.initBoard.setSquare(new Point(row,col), Square.makeEmptySquare());
					break;
				case '#':
					result.initBoard.setSquare(new Point(row,col), Square.makeBlockedSquare());
					break;
				default:
					result.initBoard.setSquare(new Point(row,col), Square.makeSquare(ch));
					break;
				}
				++idx;
			}
		}
		
		// the next three numbers are the star thresholds
		result.oneStar = sc.nextInt();
		result.twoStar = sc.nextInt();
		result.threeStar = sc.nextInt();
		
		// followed by the word limit (use 0 for unlimited)
		result.limit = sc.nextInt();
		
		// if we're in a theme level, then the remaining lines are the words
		if (result.type == THEME) {
			ArrayList<String> words = new ArrayList<String>();
			while (sc.hasNextLine()) {
				// ignore empty lines
				String s = sc.nextLine();
				if (!s.equals("")) {
					words.add(s);
				}
			}
			Dictionary d = new Dictionary();
			d.addWords(words);
			result.words = d;
		}

		sc.close();

		return result;
	}
}
