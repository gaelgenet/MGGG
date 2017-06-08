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

public class StartScreen extends RenderingScreen {

	public BitmapFont startTitle, textTitle;
	BitmapImage startbackground;
	FileHandle titleFont;

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

	@Override
	public void onGraphicRender(GdxGraphics g) {
		g.clear();
		g.resetCamera();

		// Display start screen
		g.drawTransformedPicture(HelloWorld.WINDOWS_WIDTH / 2, HelloWorld.WINDOWS_HEIGHT / 2, 0, 0.6f, startbackground);
		g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT / 2 + 100, "MGGG", startTitle);
		g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT / 2, "Mister Good Game Gold", textTitle);
		g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT / 3, "press 1 to be a man \n\n press 2 to be a woman",
				textTitle);
		g.drawStringCentered(20, "Press enter to play");

		switch (Bonhomme.sexe) {
		
		case 0:
			break;

		case 1:
			g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT / 5, "you choose to be Gaël");
			break;

		case 2:
			g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT / 5, "you choose to be Marco ");
			break;
		default:
			break;
		}

	}

	@Override
	public void onKeyDown(int keycode) {
		switch (keycode) {

		case Input.Keys.ENTER:
			Screens.getInstance().s.activateNextScreen();
			break;

		case Input.Keys.NUMPAD_1:
		case Input.Keys.NUM_1:
			Bonhomme.sexe = 1;
			break;
		case Input.Keys.NUMPAD_2:
		case Input.Keys.NUM_2:
			Bonhomme.sexe = 2;
			break;

		default:
			break;

		}
	}
}
