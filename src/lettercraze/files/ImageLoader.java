package lettercraze.files;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageLoader implements Loader {

	@Override
	public Object load(InputStream in) {
		try {
			return ImageIO.read(in);
		} catch (IOException e) {
			// the resources class will handle emitting the error message
			return null;
		}
	}

}
