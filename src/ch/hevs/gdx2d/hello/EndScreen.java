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

/**
 * this class manage the last screen when the player die
 * 
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG
 * @version 1.0
 */

public class EndScreen extends RenderingScreen {
	
	//Attributes
	public BitmapFont endTitle;
	FileHandle titleFont;
	GameOver explose = new GameOver();
	
	/**
	 * load fonts
	 */
	@Override
	public void onInit() {
		titleFont = Gdx.files.internal("data/fonts/titleFont.ttf");
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(titleFont);
		parameter.size = generator.scaleForPixelHeight(100);
		parameter.color = Color.WHITE;
		endTitle = generator.generateFont(parameter);
		
		explose.onInit();
	}

	/**
	 * draw the title, the score and the end animation
	 */
	@Override
	public void onGraphicRender(GdxGraphics g) {
		g.clear();
		g.resetCamera();
		InGameScreen.fear.dispose();
		explose.draw(g);
		explose.moveSprite();
		explose.loser(g);
		g.drawStringCentered(HelloWorld.WINDOWS_HEIGHT/2 +100 , "Game over", endTitle);
		g.drawStringCentered(50, "score : " + Bonhomme.score);
		g.drawStringCentered(20, "presse enter to play again");
	}

	/**
	 * when the user press the key enter, the game start
	 */
	@Override
	public void onKeyDown(int keycode) {
		switch(keycode){
		
		case Input.Keys.ENTER:
			Restart.restart();
			break;
		default:
			break;
		}
		
	}
}
