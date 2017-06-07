package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.components.bitmaps.Spritesheet;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

public class Bird implements DrawableObject {
	/**
	 * The size of each sprite in the sheet
	 */
	static int SPRITE_WIDTH = 109;
	static int SPRITE_HEIGHT = 100;
	/**
	 * The currently selected sprite for animation
	 */
	int textureX = 0;
	int textureY = 0;
	/**
	 * Another parametre
	 */
	float dt = 0;
	int currentFrame = 0;
	int nFrames = 3;
	double FRAME_TIME = 0.15; // Duration of each frame
	static Spritesheet sprites;
	int modul = 1;
	int posX = 900;
	int posY = 500;
	int increment = 1;

	public void moveBird() {
		dt += Gdx.graphics.getDeltaTime();

		if (dt > FRAME_TIME) {
			dt = 0;

			currentFrame += 1;
			if (currentFrame == nFrames) {
				currentFrame = 0;
				textureY += 1;
				modul++;
				if (modul % 3 == 0) {
					increment *= -1;
				}
			}

			if (textureY == 2 && currentFrame == 2) {
				textureY = 0;
				currentFrame = 0;

			}
		}
		if(posX< -580){
			posX = 980
				;
		}
		posX -= 4;

		posY += increment;

	}

	
    public Bird (int posX , int posY) {
    	this.posX = posX;
    	this.posY = posY;
    	sprites = new Spritesheet("data/images/spritbird.png", SPRITE_WIDTH, SPRITE_HEIGHT);
	
    }
	@Override
	public void draw(GdxGraphics g) {
		// TODO Auto-generated method stub
		g.draw(sprites.sprites[textureY][currentFrame], posX, posY);
		

	}

}
