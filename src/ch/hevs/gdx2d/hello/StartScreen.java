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

	public BitmapFont startTitle;
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
	}

	@Override
	public void onGraphicRender(GdxGraphics g) {
		g.clear();
		g.resetCamera();
		
		// Display start screen
		g.drawTransformedPicture(HelloWorld.WINDOWS_WIDTH/2, HelloWorld.WINDOWS_HEIGHT / 2, 0, 0.6f, startbackground);
		g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT/2 +100 , "MGGG", startTitle);
		g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT/2, "Mister Good Game Gold");
		g.drawStringCentered(20, "Press enter to play");
	}

	@Override
	public void onKeyDown(int keycode) {
		super.onKeyDown(keycode);

		// Switch to in game screen
		if (keycode == Input.Keys.ENTER)
			Screens.getInstance().s.activateNextScreen();
	}
}
