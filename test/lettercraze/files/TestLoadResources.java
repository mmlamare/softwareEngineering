package lettercraze.files;

import junit.framework.TestCase;

public class TestLoadResources extends TestCase {

	public void testLoadResources() {
		// This should re-load all resources regardless of whether they've
		// been loaded before, consequently.
		Resources.loadResources();

		assertNotNull(Resources.LB0);
		assertNotNull(Resources.LB1);
		assertNotNull(Resources.LB2);
		assertNotNull(Resources.LB3);

		assertNotNull(Resources.SI0);
		assertNotNull(Resources.SI1);
		assertNotNull(Resources.SI2);
		assertNotNull(Resources.SI3);

		assertNotNull(Resources.DICT);

		for (int i = 0; i < Resources.NUM_LEVELS; ++i) {
			assertNotNull(Resources.LEVELS[i]);
		}
	}
}
