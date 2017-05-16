package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

	protected AbstractPhysicsObject squarre;

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
		squarre = new PhysicsBox("squarre", new Vector2((SPRITE_WIDTH / 2) + 10, 500), SPRITE_HEIGHT, SPRITE_WIDTH, 1,
				0, 0);
	}

	public void onKeyUp(int keycode) {
		switch (keycode) {
		case Input.Keys.SPACE:
			squarre.applyBodyForceToCenter(new Vector2(0, 800f), true);
			break;
		default:
			break;
		}

	}

	@Override
	public void draw(GdxGraphics g) {
		int posx = (int) squarre.getBodyPosition().x;
		int posy = (int) squarre.getBodyPosition().y;

		g.drawRectangle(posx, posy, SPRITE_WIDTH, SPRITE_HEIGHT, 0);
		g.draw(sprites.sprites[textureY][currentFrame], posx - (SPRITE_WIDTH / 2), posy - (SPRITE_HEIGHT / 2));


		}

	}


