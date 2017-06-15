package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import ch.hevs.gdx2d.components.bitmaps.Spritesheet;
import ch.hevs.gdx2d.hello.Collision.CollisionType;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

/**
 * This class is used to manage the creation of the character
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG
 * @version 1.0
 */

public class Bonhomme implements DrawableObject {

	// Attributes
	protected Rectangle square;
	static Spritesheet sprites;

	// The size of each sprite in the sheet
	static int SPRITE_WIDTH = 64;
	static int SPRITE_HEIGHT = 68;

	// The currently selected sprite for animation
	int textureY = 0;

	// Animation related parameters
	float dt = 0;
	int currentFrame = 0;
	static int nFrames = 4;
	double FRAME_TIME = 0.1; // Duration of each frame

	// boolean used to jump or not
	boolean jump = false;

	// the position of the character
	int posX = 234;
	int newPosY;
	public static int offset = 20;

	public static int score = 0;

	// choose the sex of the character
	public static int sexCharacter = 0;

	// physic of the square
	private final int initSpeed = 90, Gravity = -10;
	float DT = 0.25f; // delta time used to slow the jump
	private int squareSpeed = initSpeed, deltaPosY;

	/**
	 * move the spriteSheet
	 */
	public void moveBonhomme() {

		dt += Gdx.graphics.getDeltaTime();

		if (dt > FRAME_TIME) {
			dt = 0;

			currentFrame = (currentFrame + 1) % nFrames;
		}
	}

	/**
	 * load the different pictures
	 */
	public void onInit() {
		switch (sexCharacter) {

		case 1:
			sprites = new Spritesheet("data/images/manSmall.png", SPRITE_WIDTH, SPRITE_HEIGHT);
			break;

		case 2:
			sprites = new Spritesheet("data/images/womanSmall.png", SPRITE_WIDTH, SPRITE_HEIGHT);
			break;

		case 4:

			sprites = new Spritesheet("data/images/dragodindeSmall.png", SPRITE_WIDTH, SPRITE_HEIGHT);
			break;

		default:
			sprites = new Spritesheet("data/images/manSmall.png", SPRITE_WIDTH, SPRITE_HEIGHT);
			break;
		}

		square = new Rectangle((SPRITE_WIDTH / 2) + offset, posX, SPRITE_WIDTH, SPRITE_HEIGHT);

	}

	/**
	 * allow to jump only if the collision is not left
	 * 
	 * @param collide
	 */
	public void jump(Collision.CollisionType collide) {
		if (collide != CollisionType.LEFT) {
			jump = true;
		}
	}

	/**
	 * go to the next screen when you die
	 */
	public void dead() {
		jump = false;
		Screens.getInstance().s.activateNextScreen();
	}

	/**
	 * update the physic of the character
	 * 
	 * @param collide
	 * @param cube
	 */
	public void physics_update(Collision.CollisionType collide, CubeManager cube) {

		newPosY = (int) cube.cubes.get(0).rectangle.height / 2 + (SPRITE_HEIGHT / 2);

		// simulate the gravity when the character jump
		if (jump == true) {
			squareSpeed = (int) (squareSpeed + (DT * Gravity));
			deltaPosY = (int) (DT * squareSpeed);
			square.y = square.y + deltaPosY;
		}

		// when the character touch the platform -> update the position Y
		if (collide == CollisionType.TOP) {
			square.y = newPosY;
			squareSpeed = initSpeed;
			score++;
			jump = false;
		}

		// When the collision is END. Let the character fall
		if (collide == CollisionType.END) {
			squareSpeed = -(initSpeed / 2);
			jump = true;
		}

		// When the character touch the left side of the platform, he dies
		if ((collide == CollisionType.LEFT || square.y <= 100)) {
			dead();

		}
	}

	/**
	 * draw the sprite sheet
	 */
	@Override
	public void draw(GdxGraphics g) {

		g.draw(sprites.sprites[textureY][currentFrame], square.x - (SPRITE_WIDTH / 2), square.y - (SPRITE_HEIGHT / 2));
	}

}
