package lettercraze.files;

import java.awt.Image;
import java.io.InputStream;

import lettercraze.model.Dictionary;
import lettercraze.model.Level;


/**
 * This class handles loading all static resources from the JAR file.
 * This includes images, levels, and the dictionary.
 * This class also contains the code for loading levels and the dictionary,
 * which isn't terribly complex.
 * 
 * @author Ruthenium
 * @version 1.0
 */
public class Resources {
	/** This is the number of statically loaded levels. */
	public static final int NUM_LEVELS=15;

	/** Level button Icon */
	public static Image LB0;
	/** Level button Icon */
	public static Image LB1;
	/** Level button Icon */
	public static Image LB2;
	/** Level button Icon */
	public static Image LB3;
	
	/** score indicator image */
	public static Image SI0;
	/** score indicator image */
	public static Image SI1;
	/** score indicator image */
	public static Image SI2;
	/** score indicator image */
	public static Image SI3;

	/** Game levels */ 
	public static Level[] LEVELS;
	
	/** The default English dictionary */
	public static Dictionary DICT;
	
	/**
	 * Create an InputStream from a resource name
	 * @param resourceName The string name of the inputed resource
	 * @return The stream of inputed characters
	 */
	public static InputStream getStream(String resourceName) {
		return Thread.currentThread().getContextClassLoader().
				getResourceAsStream(resourceName);
	}

	/** Load all static resources from the archive */ 
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

	/**
	 * This is the abstract method for loading resources
	 * @param resourceName The string name of the input resource
	 * @param l Loader object
	 * @return General output object
	 */
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

	/**
	 * @param resourceName
	 * @return The loaded dictionary
	 */
	public static Dictionary loadDictionary(String resourceName) {
		return (Dictionary) loadResource(resourceName, new DictionaryLoader());
	}
	
	/**
	 * @param resourceName
	 * @return The loaded level
	 */
	public static Level loadLevel(String resourceName) {
		return (Level) loadResource(resourceName, new LevelLoader());
	}
	
	/**
	 * @param resourceName
	 * @return The loaded resource
	 */
	public static Image loadImage(String resourceName) {
		return (Image) loadResource(resourceName, new ImageLoader());
	}
}
