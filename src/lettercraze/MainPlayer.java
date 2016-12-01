package lettercraze;

import java.util.concurrent.TimeUnit;

import lettercraze.files.Data;
import lettercraze.files.Resources;
import lettercraze.model.Model;
import lettercraze.view.LetterCraze;
import lettercraze.view.SplashScreenView;

public class MainPlayer {

	public static void main(String args[]) {
		// Load static resources from within the JAR file
		Resources.loadResources();
		// Ensure that we have access to the game's data directory
		if (!Data.dataPathExists()) {
			Data.createDataPath();
		}
		
		String values[] = {"LetterCraze Player", "Ruthenium", "Jacob", "Matt", "Jack", "Andrew", "Cam"};
		SplashScreenView splash = new SplashScreenView(values);
		
		try
		{
			System.out.println("Sleeping for 5 seconds...");
			TimeUnit.SECONDS.sleep(5);
			splash.dispose();
		}
		catch (InterruptedException e)
		{
			System.out.println("Sleep interrupted: " + e.getMessage());
		}

		Model m = new Model(Data.readScores());
		new LetterCraze(m);
	}
	
}
