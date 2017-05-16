package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ch.hevs.gdx2d.components.bitmaps.Spritesheet;
import ch.hevs.gdx2d.components.physics.primitives.PhysicsBox;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;
import ch.hevs.gdx2d.lib.physics.AbstractPhysicsObject;


public class Bonhomme implements DrawableObject {

	Vector2 position;
	String name;
	/**
	 * The size of each sprite in the sheet
	 */
	static int SPRITE_WIDTH = 128;
	static int SPRITE_HEIGHT = 128;

	protected Rectangle squarre;

	/**
	 * The currently selected sprite for animation
	 */
	int textureX = 0;
	int textureY = 0;

	/**
	 * Animation related parameters
	 */

	float dt = 0;
	int currentFrame = 0;
	int nFrames = 4;
	double FRAME_TIME = 0.1; // Duration of each frame
	static Spritesheet sprites;

	public void moveBonhomme() {
		
		dt += Gdx.graphics.getDeltaTime();
		
		if (dt > FRAME_TIME) {
			dt = 0;

			currentFrame = (currentFrame + 1) % nFrames;
			System.out.println("c :" + currentFrame);

			if (currentFrame % 4 == 0) {
				textureY = (textureY + 1) % 4;
			}
			// System.out.println(textureY);
	}}

	public void collision(AbstractPhysicsObject other, float energy) {

	}

	public void onInit() {
		sprites = new Spritesheet("data/images/smurf.png", SPRITE_WIDTH, SPRITE_HEIGHT);
		squarre = new Rectangle(SPRITE_WIDTH / 2 + 10,500,SPRITE_WIDTH,SPRITE_HEIGHT);
		
	}

	public void onKeyUp(int keycode) {
		switch (keycode) {
		case Input.Keys.SPACE:
			
			break;
		default:
			break;
		}

	}

	@Override
	public void draw(GdxGraphics g) {
		
		
		g.drawRectangle(squarre.x, squarre.y, SPRITE_WIDTH, SPRITE_HEIGHT, 0);
		g.draw(sprites.sprites[textureY][currentFrame], squarre.x- (SPRITE_WIDTH / 2), squarre.y   - (SPRITE_HEIGHT / 2));


		}

	}


