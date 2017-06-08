package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ch.hevs.gdx2d.components.bitmaps.Spritesheet;

import ch.hevs.gdx2d.hello.Collision.CollisionType;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;
import ch.hevs.gdx2d.lib.utils.Logger;

public class Bonhomme implements DrawableObject {

	Vector2 position;
	String name;
	HelloWorld hello;
	CubeManager cube = new CubeManager();

	/**
	 * The size of each sprite in the sheet
	 */
	static int SPRITE_WIDTH = 64;
	static int SPRITE_HEIGHT = 68;

	protected Rectangle square;

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
	static boolean move = false;
	boolean dead = false;
	int cubeHeigh = 234;
	int cubeNewHeight;
	public static int score= 0;
	public static int sexe = 0;

	/**
	 * physic of the squarre
	 */
	private final int Vinit = 90, Gravity = -10, V_boost = 5;
	float DT = 0.25f;
	private int Vsquarre = Vinit, deltaPosY;

	public void moveBonhomme() {

		dt += Gdx.graphics.getDeltaTime();

		if (dt > FRAME_TIME) {
			dt = 0;

			currentFrame = (currentFrame + 1) % nFrames;
			// System.out.println("c :" + currentFrame);

//			if (currentFrame % 4 == 0) {
//				textureY = (textureY + 1) % 4;
			}
			// System.out.println(textureY);
		//}
	}

	public void onInit() {
		switch (sexe){

		
		case 0:
			sprites = new Spritesheet("data/images/manSmall.png", SPRITE_WIDTH, SPRITE_HEIGHT);
			break;
			
		case 1:
			sprites = new Spritesheet("data/images/manSmall.png", SPRITE_WIDTH, SPRITE_HEIGHT);
			break;
			
		case 2:
			sprites = new Spritesheet("data/images/womanSmall.png", SPRITE_WIDTH, SPRITE_HEIGHT);
			break;
		}
		
		square = new Rectangle(SPRITE_WIDTH / 2 + 10, cubeHeigh, SPRITE_WIDTH, SPRITE_HEIGHT);

	}

	public void jump(Collision.CollisionType collide) {
		if (collide != CollisionType.LEFT) {
			move = true;
		}
	}

	public void dead() {
			Cube.play = false;
			CubeManager.play = false;
			move = false;
			Logger.log("tu es mort");
			Vsquarre = 0;
			//dead = true;
			Screens.getInstance().s.activateNextScreen();
			
		}

	public void physics_update(Collision.CollisionType collide, CubeManager cube) {

		cubeNewHeight = (int) cube.cubes.get(0).rectangle.height / 2 + (SPRITE_HEIGHT / 2);

		if (move == true) {
			Vsquarre = (int) (Vsquarre + (DT * Gravity));
			deltaPosY = (int) (DT * Vsquarre);
			square.y = square.y + deltaPosY;
			Logger.log("posisiton y : " + square.y);

		}

		if (collide == CollisionType.TOP) {
			square.y = cubeNewHeight;
			Vsquarre = Vinit;
			score++;
			move = false;
		}
		if (collide == CollisionType.END) {
			Vsquarre = -(Vinit / 2);
			move = true;
		}
		if ((collide == CollisionType.LEFT || square.y <= 100)) {
			dead();
			
		}
	}

	@Override
	public void draw(GdxGraphics g) {

		//g.drawRectangle(square.x, square.y, square.width, square.height,0);
		g.draw(sprites.sprites[textureY][currentFrame], square.x - (SPRITE_WIDTH / 2), square.y - (SPRITE_HEIGHT / 2));
	}

}
