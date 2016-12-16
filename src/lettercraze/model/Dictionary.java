package lettercraze.model;

import java.util.ArrayList;

/**
 * This is the class for storing and mutating the dictionary
 * @author Ruthenium
 * @version 1.0
 */
public class Dictionary {
	ArrayList<String> words;

	/**
	 * Dictionary Constructor
	 */
	public Dictionary() {
		words = new ArrayList<String>();
	}

	/**
	 * Returns T/F whether the input string is in the dictionary.
	 * @param word The string that is being evaluated
	 * @return T/F whether the inputed string is in the dictionary
	 */
	public boolean isWord(String word) {
		return words.contains(word);
	}

	/**
	 * Adds a single word to the dictionary
	 * @param word The word to be added
	 */
	public void addWord(String word) {
		this.words.add(word);
	}

	/**
	 * Adds an array of strings to the dictionary
	 * @param words An array of strings that are the words 
	 * to be added to the dictionary
	 */
	public void addWords(String[] words) {
		for (int i =0; i<words.length; ++i) {
			this.words.add(words[i]);
		}
	}

	/**
	 * Adds an arrayList of strings to the dictionary
	 * @param words An arraylist of strings that are words to be
	 * added to the dictionary
	 */
	public void addWords(ArrayList<String> words) {
		for (String s : words) {
			this.words.add(s);
		}
	}

	/**
	 * Get the raw ArrayList of words
	 * @return The ArrayList
	 */
	public ArrayList<String> getList() {
		return this.words;
	}

	/**
	 * Remove a word from the dictionary
	 * @param word the word to remove
	 */
	public void removeWord(String word) {
		this.words.remove(word);
	}
}
