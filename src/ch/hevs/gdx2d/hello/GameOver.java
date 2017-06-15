package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.components.bitmaps.Spritesheet;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

/**
 * this class manage the animation of the game over screen
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */

public class GameOver implements DrawableObject {

	// Attributes
	static Spritesheet loser;
	static BitmapImage loser2;

	// The size of each sprite in the sheet
	static int SPRITE_WIDTH = 150;
	static int SPRITE_HEIGHT = 356;

	// The currently selected sprite for animation
	int textureX = 0;
	int textureY = 0;

	// Animation related parameters
	float dt = 0;
	int currentFrame = 0;
	int nFrames = 4;
	double FRAME_TIME = 0.15; // Duration of each frame

	// parametre of loser2
	int var1 = 1;
	int var2 = 1;
	float inc1 = 0.01f;
	float inc2 = 0.01f;
	float alpha = 0.7f;
	float scale = 0.7f;
	float angle = 0;

	// parameter positions
	int posx = 800;
	int posy = 40;

	/**
	 * movement of sprite
	 */
	public void moveSprite() {
		dt += Gdx.graphics.getDeltaTime();

		if (dt > FRAME_TIME) {
			dt = 0;
			currentFrame += 1;
			if (currentFrame == nFrames) {
				currentFrame = 0;
			}
		}

	}

	/**
	 * animation of loser 2
	 * 
	 * @param g
	 */
	public void loser(GdxGraphics g) {
		if (posx > 325) {
			posx -= 2;
		}

		if (var1 % 20 == 0) {
			inc1 *= -1;
		}
		if (var2 % 25 == 0) {
			inc2 *= -1;
		}
		scale += inc1;
		alpha += inc2;
		var1++;
		var2++;
	}

	/**
	 * initialize images
	 */
	public void onInit() {
		loser = new Spritesheet("data/images/loser.png", SPRITE_WIDTH, SPRITE_HEIGHT);
		loser2 = new BitmapImage("data/images/loser2.png");
	}

	/**
	 * drawing images
	 */
	@Override
	public void draw(GdxGraphics g) {

		g.draw(loser.sprites[textureY][currentFrame], posx, posy);
		if (posx <= 325) {
			g.drawAlphaPicture(400, 550, angle, scale, alpha, loser2);
		}

	}

}
