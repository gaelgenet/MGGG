package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.desktop.PortableApplication;

/**
 * the main class of the project
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 2.1
 */
public class HelloWorld extends PortableApplication {

	//Attributes
	public static final int WINDOWS_WIDTH = 800, WINDOWS_HEIGHT = 700;

	/**
	 * constructor
	 */
	public HelloWorld() {
		super(WINDOWS_WIDTH, WINDOWS_HEIGHT);
	}

	/**
	 * instance the different screen of the game
	 */
	@Override
	public void onInit() {

		setTitle("MGGG");

		// Screen manager
		Screens.getInstance().s.registerScreen(StartScreen.class);
		Screens.getInstance().s.registerScreen(InGameScreen.class);
		Screens.getInstance().s.registerScreen(EndScreen.class);

	}

	/**
	 * active the screens after touching the keys 
	 */
	@Override
	public void onKeyDown(int keycode) {
		// Delegate to the child class
		Screens.getInstance().s.getActiveScreen().onKeyDown(keycode);
	}

	/**
	 * read the actual instance
	 */
	@Override
	public void onGraphicRender(GdxGraphics g) {
		// Delegate to the child class
		Screens.getInstance().s.render(g);

	}

	/**
	 * Main with the instance of the game
	 * @param args
	 */
	public static void main(String[] args) {
		new HelloWorld();
	}

}
