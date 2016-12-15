package lettercraze.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * This is the class for reading and writing level files.
 * @author Ruthenium
 * @version 1.0
 */
public class Data {
	/** Holds the files extension data path. */
	public static final String DATA_PATH = "/.lettercraze/";
	/** Holds a generic extension for a score file */
	public static final String SCORE_FILE = "scores.txt";

	/**
	 * @param name name of file without an extension
	 * @return The full file name
	 */
	public static String pathToData(String name) {
		return System.getProperty("user.home") + DATA_PATH + name;
	}
	 
	/**
	 * check if the data path exists
	 * @return T/F if the data path exists
	 */
	public static boolean dataPathExists() {
		File f = new File(pathToData(""));
		return f.isDirectory();
	}
	
	/**
	 * create the data directory (or fail and complain)
	 */
	public static void createDataPath() {
		File f = new File(pathToData(""));
		if(!f.mkdir()) {
			System.out.println("Could not create data directory at " + pathToData(""));
			System.out.println("Scores and progress will not be saved.");
		}
	}

	/**
	 * Attempt to read scores.
	 * If the file is not found, assume 0 stars for every level.
	 * @return list of scores
	 */
	public static int[] readScores() {
		File f = new File(pathToData(SCORE_FILE));
		int[] result = new int[Resources.NUM_LEVELS];
		for (int i = 0; i < Resources.NUM_LEVELS; ++i) {
			result[i] = 0;
		}
		try {
			// the scores file is just a space-separated list of 15 integers,
			// so a simple Scanner suffices
			Scanner sc = new Scanner(f);
			for (int i=0; i < Resources.NUM_LEVELS && sc.hasNextInt(); ++i) {
				result[i] = sc.nextInt();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// Don't do anything yet, but complain to the user
			System.out.println("No scores.txt file found at expected location " +
					pathToData(SCORE_FILE));
		}
		return result;
	}
	
	/**
	 * Attempt to write the scores
	 * @param scores The list of scores
	 */
	public static void writeScores(int[] scores) {
		try {
			System.out.println("writing file");
			PrintWriter out = new PrintWriter(pathToData(SCORE_FILE),"ASCII");
			for (int i = 0; i < scores.length; ++i) {
				out.println(scores[i]);
			}
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not open " + pathToData(SCORE_FILE) +
					" for writing. Scores have not been saved.");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Could not open " + pathToData(SCORE_FILE) +
					" for writing. Scores have not been saved.");
			e.printStackTrace();
		}
	}
}
