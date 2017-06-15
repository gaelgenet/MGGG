package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.lib.ScreenManager;

/**
 * this class creat a new instance of screens if need it
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */
public class Screens {

	// Attributes
	private static Screens instance;
	public ScreenManager s = new ScreenManager();

	/**
	 * constructor
	 */
	private Screens() {
	}

	/**
	 * create new screen
	 * 
	 * @return
	 */
	public static Screens getInstance() {
		if (instance == null) {
			instance = new Screens();
			return instance;
		} else
			return instance;
	}
}
