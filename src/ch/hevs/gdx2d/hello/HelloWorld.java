package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.desktop.PortableApplication;
//moi
/**
 * Hello World demo.
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 2.1
 */
public class HelloWorld extends PortableApplication {

	public static final int WINDOWS_WIDTH = 800, WINDOWS_HEIGHT = 700;

	public HelloWorld() {
		super(WINDOWS_WIDTH, WINDOWS_HEIGHT);
	}

	@Override

	public void onInit() {

		setTitle("MGGG");

		// Screen manager
		Screens.getInstance().s.registerScreen(StartScreen.class);
		Screens.getInstance().s.registerScreen(InGameScreen.class);
		Screens.getInstance().s.registerScreen(EndScreen.class);

	}

	@Override
	public void onKeyUp(int keycode) {
		// Delegate to the child class
		Screens.getInstance().s.getActiveScreen().onKeyUp(keycode);

	}

	@Override
	public void onKeyDown(int keycode) {
		// Delegate to the child class
		Screens.getInstance().s.getActiveScreen().onKeyDown(keycode);
	}

	@Override
	public void onGraphicRender(GdxGraphics g) {
		// Delegate to the child class
		Screens.getInstance().s.render(g);

	}

	public static void main(String[] args) {
		new HelloWorld();
	}

}
