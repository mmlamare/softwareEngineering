package lettercraze.files;

import java.io.InputStream;

/**
 * Interface for various Loading classes
 * @author Jack Pugmire
 *
 */
public interface Loader {
	
	/**
	 * @param in The input steam of characters
	 * @return The generic output object
	 */
	public abstract Object load(InputStream in);

}