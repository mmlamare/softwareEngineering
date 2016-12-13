package lettercraze;


import java.util.concurrent.TimeUnit;

import lettercraze.files.Data;
import lettercraze.files.Resources;
import lettercraze.model.board.ModelBuilder;
import lettercraze.view.BuilderView;
import lettercraze.view.LetterCraze;
import lettercraze.view.SplashScreenView;

/**
 * The Main class that launches the builder view.
 * It first begins by launching the splash screen for 5 seconds.
 * After the splash screen closes the builder view will be launched immediately. 
 */
public class MainBuilder {

	public static void main(String[] args) {
		// Load static resources from within the JAR file
		Resources.loadResources();
		
		// Ensure that we have access to the game's data directory
		if (!Data.dataPathExists()) {
			Data.createDataPath();
		}
		
		String values[] = {"LetterCraze Builder", "Ruthenium", "Jacob", "Matt", "Jack", "Andrew", "Cam"};
		/*SplashScreenView splash = new SplashScreenView(values);
		
		try
		{
			System.out.println("Sleeping for 5 seconds...");j
			TimeUnit.SECONDS.sleep(5);
			splash.dispose();
		}
		catch (InterruptedException e)
		{
			System.out.println("Sleep interrupted: " + e.getMessage());
		}*/
		
		
		ModelBuilder m = new ModelBuilder();
		new BuilderView(m);
	}

}
