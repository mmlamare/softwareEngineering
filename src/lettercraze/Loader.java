package lettercraze;

import java.io.InputStream;

public interface Loader {
	public abstract Object load(InputStream in);
}
