package lettercraze.files;

import java.awt.Image;
import java.io.InputStream;

import lettercraze.model.Dictionary;
import lettercraze.model.Level;

// This class handles loading all static resources from the JAR file. This
// includes images, levels, and the dictionary. This class also contains the
// code for loading levels and the dictionary, which isn't terribly complex.
public class Resources {
	// This is the number of statically loaded levels.
	public static final int NUM_LEVELS=15;

	// Level button Icons
	public static Image LB0;
	public static Image LB1;
	public static Image LB2;
	public static Image LB3;
	
	// score indicator images
	public static Image SI0;
	public static Image SI1;
	public static Image SI2;
	public static Image SI3;

	// Game levels
	public static Level[] LEVELS;
	
	// The default english dictionary
	public static Dictionary DICT;
	
	// Create an InputStream from a resource name
	public static InputStream getStream(String resourceName) {
		return Thread.currentThread().getContextClassLoader().
				getResourceAsStream(resourceName);
	}

	// Load all static resources from the archive
	public static void loadResources() {
		LB0 = loadImage("lb-0.png");
		LB1 = loadImage("lb-1.png");
		LB2 = loadImage("lb-2.png");
		LB3 = loadImage("lb-3.png");

		SI0 = loadImage("si-0.png");
		SI1 = loadImage("si-1.png");
		SI2 = loadImage("si-2.png");
		SI3 = loadImage("si-3.png");

		LEVELS = new Level[NUM_LEVELS];
		for (int i = 0; i < NUM_LEVELS; ++i) {
			LEVELS[i] = loadLevel("level" + i);
		}
		
		DICT = loadDictionary("english.dict");
	}

	public static Object loadResource(String resourceName, Loader l) {
		InputStream in = getStream(resourceName);
		if (in == null) {
			System.err.println("Resources: Could not locate resource with name: " + resourceName);
			return null;
		}
		Object result = l.load(in);
		if (result == null) {
			System.err.println("Resources: Invalid format for resource: " + resourceName);
		}

		return result;
	}

	public static Dictionary loadDictionary(String resourceName) {
		return (Dictionary) loadResource(resourceName, new DictionaryLoader());
	}
	public static Level loadLevel(String resourceName) {
		return (Level) loadResource(resourceName, new LevelLoader());
	}
	public static Image loadImage(String resourceName) {
		return (Image) loadResource(resourceName, new ImageLoader());
	}
}
