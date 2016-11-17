package lettercraze.model;

import java.util.ArrayList;

public class Dictionary {
	ArrayList<String> words;

	public Dictionary() {
		words = new ArrayList<String>();
	}

	public boolean isWord(String word) {
		return words.contains(word);
	}

	public void addWord(String word) {
		this.words.add(word);
	}

	public void addWords(String[] words) {
		for (int i =0; i<words.length; ++i) {
			this.words.add(words[i]);
		}
	}

	public void addWords(ArrayList<String> words) {
		for (String s : words) {
			this.words.add(s);
		}
	}
}
