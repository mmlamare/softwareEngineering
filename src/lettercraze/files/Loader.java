package lettercraze.files;

import java.io.InputStream;

public interface Loader {
	
	public abstract Object load(InputStream in);

}