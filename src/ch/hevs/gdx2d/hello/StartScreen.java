package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.components.screen_management.RenderingScreen;
import ch.hevs.gdx2d.lib.GdxGraphics;

/**
 * this class manage the Start screen
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */
public class StartScreen extends RenderingScreen {
	// Attributes
	public BitmapFont startTitle, textTitle;
	BitmapImage startbackground;
	BitmapImage startDofusBack;
	FileHandle titleFont;

	public static int playerChoise = 1;
	public static int playerDofus = 0;
	public static int world = 0;

	/**
	 * creat a new font
	 */
	@Override
	public void onInit() {
		titleFont = Gdx.files.internal("data/fonts/titleFont.ttf");
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(titleFont);
		parameter.size = generator.scaleForPixelHeight(100);
		parameter.color = Color.WHITE;

		startbackground = new BitmapImage("data/images/startBackground.jpg");

		startTitle = generator.generateFont(parameter);

		parameter.size = generator.scaleForPixelHeight(20);
		textTitle = generator.generateFont(parameter);
	}

	/**
	 * initialize the picture
	 */
	public void onInit2() {
		startDofusBack = new BitmapImage("data/images/fonddofus.fpg");
	}

	/**
	 * draw the title and the instructions
	 */
	@Override
	public void onGraphicRender(GdxGraphics g) {
		g.clear();
		g.resetCamera();

		g.drawTransformedPicture(HelloWorld.WINDOWS_WIDTH / 2, HelloWorld.WINDOWS_HEIGHT / 2, 0, 0.6f, startbackground);
		g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT / 2 + 100, "MGGG", startTitle);
		g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT / 2, "Mister Good Game Gold", textTitle);
		g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT / 3, "press 1 to be a man \n\n press 2 to be a woman",
				textTitle);
		g.drawStringCentered(40, "Press space to jump");
		g.drawStringCentered(20, "Press enter to play");

		// choose to be a mana or a women
		switch (Bonhomme.sexCharacter) {

		case 1:
			g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT / 5, "you choose to be man");
			break;

		case 2:
			g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT / 5, "you choose to be a woman ");
			break;

		default:
			break;
		}

	}

	/**
	 * choose to be a man or a woman
	 */
	@Override
	public void onKeyDown(int keycode) {
		switch (keycode) {

		case Input.Keys.ENTER:
			Screens.getInstance().s.activateNextScreen();
			break;

		case Input.Keys.NUMPAD_1:
		case Input.Keys.NUM_1:
			Bonhomme.sexCharacter = 1;
			playerChoise = 1;
			world = 0;
			break;
		case Input.Keys.NUMPAD_2:
		case Input.Keys.NUM_2:
			Bonhomme.sexCharacter = 2;
			playerChoise = 2;
			world = 0;
			break;

		default:
			break;

		}
	}
}
