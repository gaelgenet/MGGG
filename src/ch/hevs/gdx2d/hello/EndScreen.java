package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import ch.hevs.gdx2d.components.screen_management.RenderingScreen;
import ch.hevs.gdx2d.lib.GdxGraphics;

public class EndScreen extends RenderingScreen {
	
	public BitmapFont endTitle;
	FileHandle titleFont;

	@Override
	public void onInit() {
		titleFont = Gdx.files.internal("data/fonts/titleFont.ttf");
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(titleFont);
		parameter.size = generator.scaleForPixelHeight(100);
		parameter.color = Color.WHITE;
		
		endTitle = generator.generateFont(parameter);
	}

	@Override
	public void onGraphicRender(GdxGraphics g) {
		g.clear();
		g.resetCamera();
		
		// Display ending screen
		g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT/2 +100 , "Game over", endTitle);
		g.drawStringCentered(50, "score : " + Bonhomme.score);
		g.drawStringCentered(20, "presse enter to play again");
	}

	@Override
	public void onKeyDown(int keycode) {
		switch(keycode){
		
		case Input.Keys.ENTER:
			Cube.play = true;
			CubeManager.play = true;
			Bonhomme.score = 0;
			Screens.getInstance().s.activateScreen(1);
			break;
		default:
			break;
		}
		
	}
}