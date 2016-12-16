package lettercraze.view;

import junit.framework.TestCase;

public class TestSplashScreenView extends TestCase {

	public void testSplashScreenView(){
		String list[] = {"one", "two", "three", "four", "five", "six", "seven"};
		SplashScreenView splash = new SplashScreenView(list);
		splash.initialize();
	}
}
