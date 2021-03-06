package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Gdx;


import ch.hevs.gdx2d.components.bitmaps.Spritesheet;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

/**
 * This class create a bat 
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */

public class Bat implements DrawableObject {

	// Attributes
	static Spritesheet sprites;

	// The size of each sprite in the sheet

	static int SPRITE_WIDTH = 75;
	static int SPRITE_HEIGHT = 77;

	// The currently selected sprite for animation
	int currentFrame = 0;
	int textureY = 0;

	// Animation related parameters
	float dt = 0;
	int nFrames = 4;
	double FRAME_TIME = 0.15; // Duration of each frame
	int nChange = 1;
	int direction = 1;
	int deplacementX = 4;

	// parameter positions
	int posX;
	int posY;

	/**
	 * constructor
	 * 
	 * @param posX
	 * @param posY
	 */

	public Bat(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;

		sprites = new Spritesheet("data/images/bat2.png", SPRITE_WIDTH, SPRITE_HEIGHT);
	}

	/**
	 * movement of the bat
	 */

	public void moveBat() {
		dt += Gdx.graphics.getDeltaTime();

		if (dt > FRAME_TIME) {
			dt = 0;

			currentFrame += 1;
			if (currentFrame == nFrames) {
				currentFrame = 0;
				//textureY += 1;
				nChange++;
				if (nChange % 3 == 0) {
					direction *= -1;
				}
			}


		}
		if (posX < -580) {
			posX = 980;
		}
		posX -= deplacementX;

		posY += direction;

	}

	@Override
	public void draw(GdxGraphics g) {
		// TODO Auto-generated method stub
		g.draw(sprites.sprites[textureY][currentFrame], posX, posY);

	}

}
