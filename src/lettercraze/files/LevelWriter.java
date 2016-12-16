package lettercraze.files;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import lettercraze.model.LevelType;
import lettercraze.model.board.Board;
import lettercraze.model.board.Point;
import lettercraze.model.Level;

public class LevelWriter {
	public static boolean writeLevel(Level l, File dest) {
		PrintWriter writer = null;
		try {
		    writer = new PrintWriter(dest, "UTF-8");
		    String typeStr = "";
			switch (l.type) {
			case PUZZLE:
				typeStr = "puzzle";
				break;
			case LIGHTNING:
				typeStr = "lightning";
				break;
			case THEME:
				typeStr = "theme";
				break;
			}
			writer.println(typeStr);

			writer.println(l.name);

			// write the board data
			for (int row=0; row < Board.SIZE; ++row) {
				for (int col=0; col < Board.SIZE; ++col) {
					Point p = new Point(row, col);
					if (l.initBoard.isBlocked(p)) {
						writer.print('#');
					} else if (l.initBoard.isEmpty(p)) {
						writer.print('.');
					} else if (l.initBoard.isLetter(p)) {
						writer.print(l.initBoard.getLetter(p));
					}
				}
			}
			writer.println();
			
			// write the level thresholds
			writer.println(l.oneStar + " " + l.twoStar + " " + l.threeStar);

			// write the max words
			writer.println(l.limit);
			
			// if we're in a theme level, write the dictionary
			if (l.type == LevelType.THEME) {
				for (String s : l.words.getList()) {
					writer.println(s);
				}
			}
			writer.close();
			return true;

		} catch (IOException e) {
			System.err.println("Failed writing level.");
			return false;
		}
	}
}
