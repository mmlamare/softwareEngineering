package lettercraze;

import lettercraze.files.Data;
import lettercraze.files.Resources;
import lettercraze.model.ModelBuilder;
import lettercraze.view.LetterCraze;

public class MainBuilder {

	public static void main(String[] args) {
		// Load static resources from within the JAR file
		Resources.loadResources();
		
		// Ensure that we have access to the game's data directory
		if (!Data.dataPathExists()) {
			Data.createDataPath();
		}
		
		ModelBuilder m = new ModelBuilder();
		//new Builder(m);
	}

}
