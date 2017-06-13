package ch.hevs.gdx2d.hello;

import java.util.Random;

import java.util.Vector;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import ch.hevs.gdx2d.lib.GdxGraphics;

/**
 * this class manage all the different platforms.
 * 
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG
 * @version 1.0
 */

public class CubeManager {

	// class' instances
	Color c = Color.WHITE;
	Random r = new Random();

	Vector<Cube> cubes = new Vector<Cube>();

	// variables for the creation of the platform
	int posx = 1000;
	int posy = 0;
	int width;
	int heigh;

	// time between the creation of the each platform
	float dt;
	float variablespeed = 1.8f;

	// accelerate the speed of the platform
	static float speedTime;
	float speed = -4;

	// other
	static boolean play = true;
	public static float position = 0;

	/**
	 * generate a new random platform each X time
	 */
	void generatecube() {

		dt += Gdx.graphics.getDeltaTime();

		if (play == true && dt > variablespeed && cubes.lastElement().rectangle.y >= 0) {

			dt = 0;

			width = 200;

			heigh = (int) (Math.random() * 700);

			if (heigh <= 350 || heigh >= 600) {
				heigh = 500;
			}

			cubes.add(new Cube(posx, posy, width, heigh, new Color(r.nextInt())));

		}

	}

	/**
	 * When the platform goes to far away, it will be destroy
	 */
	void distroyCube() {
		if (cubes.get(0).rectangle.x <= -(cubes.get(0).rectangle.width / 2) - 10) {
			cubes.remove(0);
		}
	}

	/**
	 * move each platform with a constant speed or with a accelerating speed
	 */
	public void speedCube(GdxGraphics g) {

		position = cubes.get(0).rectangle.x + (cubes.get(0).rectangle.width / 2);

		// accelerating speed-----------------------------------------

		 speedTime += Gdx.graphics.getDeltaTime();
		 if (play == true && speedTime > 7) {
		 speed -= 0.1;
		 variablespeed += 0.005;
		 speedTime = 0;
		 }

		// -------------------------------------------------------------

		for (Cube c : cubes) {
			c.draw(g);
			c.move(speed);
		}
	}

	/**
	 * generate the first three platforms
	 */
	public void generateInitialCubes() {
		cubes.add(new Cube(200, posy, 400, 400, new Color(Color.YELLOW)));
		cubes.add(new Cube(650, posy, 200, 400, new Color(Color.YELLOW)));
		cubes.add(new Cube(posx, posy, 200, 400, new Color(Color.YELLOW)));

	}

}
