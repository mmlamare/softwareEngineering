package lettercraze.files;

import java.io.InputStream;
import java.util.Scanner;

import lettercraze.model.Dictionary;

/**
 * This class loads in the dictionary
 * @authors Jack Pugmire, Matthew Lamare
 * @version 1.0
 */
public class DictionaryLoader implements Loader {
	public Object load(InputStream in) {
		Scanner sc = new Scanner(in);
		Dictionary result = new Dictionary();
		while (sc.hasNextLine()) {
			String w = sc.nextLine();
			result.addWord(w);
		}
		sc.close();

		return result;
	}
}
