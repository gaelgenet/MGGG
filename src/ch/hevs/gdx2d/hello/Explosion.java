package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.components.bitmaps.Spritesheet;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

public class Explosion  implements DrawableObject{
	
	
	static int SPRITE_WIDTH = 96;
	static int SPRITE_HEIGHT = 96;

	
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
	int nFrames = 5;
	double FRAME_TIME = 0.15; // Duration of each frame
	static Spritesheet explose;
	
	
	public void moveSprite() {
		dt += Gdx.graphics.getDeltaTime();

		if (dt > FRAME_TIME) {
			dt = 0;

			currentFrame += 1;
			if (currentFrame == nFrames) {
				currentFrame = 0;
				textureY += 1;

			}

			if (textureY == 2 && currentFrame == 4) {
				textureY = 0;
				currentFrame = 0;

			}}
		}
	
	public void onInit(){
		explose = new Spritesheet("data/images/explosion-sprite.png", SPRITE_WIDTH, SPRITE_HEIGHT);
		
	}
	@Override
	public void draw(GdxGraphics g) {
		// TODO Auto-generated method stub
		g.draw(explose.sprites[textureY][currentFrame],400,400);
		
	}

}
