package ch.hevs.gdx2d.hello;

import java.util.Random;
import java.util.Vector;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.utils.Logger;

public class CubeManager {

	Vector<Cube> cubes = new Vector<Cube>();

	float dt;
	float speedTime;
	int posx = 1000;
	int posy = 0;
	int width;
	int heigh;
	float speed = -4;
	float variablespeed = 2f;
	static boolean play = true;

	Color c = Color.WHITE;

	Random r = new Random();

	void generatecube() {

		dt += Gdx.graphics.getDeltaTime();

		// Logger.log("Current time " + dt);
		if (play == true && dt > variablespeed && cubes.lastElement().rectangle.y >= 0) {
			// Logger.log("Generating a CUBBEEEEE!");
			dt = 0;
			
			width = (int) (Math.random() * 600);
			
			if (width <= 250 || width >= 400) {
				width = 250;
			}
			heigh = (int) (Math.random() * 700);

			if (heigh <= 350 || heigh >= 600) {
				heigh = 500;
			}
			
			cubes.add(new Cube(posx, posy, width, heigh, new Color(r.nextInt())));

		}

	}

	void distroyCube() {
		if (cubes.get(0).rectangle.x <= -(cubes.get(0).rectangle.width/2)-10) {
			//Logger.log("cube"+cubes.get(0)+"is destroyed");
			cubes.remove(0);
		}
	}

	public void speedCube(GdxGraphics g) {
		speedTime += Gdx.graphics.getDeltaTime();
		//Logger.log("pouet" + speedTime);

		if (play == true && speedTime > 7) {
			speed -= 0.1;
			//variablespeed -= 0.1;
			speedTime = 0;
		}

		for (Cube c : cubes) {
			c.draw(g);
			c.move(speed);
		}
		//Logger.log("salut" + speed + "");
	}

	public void generateInitialCubes() {
		cubes.add(new Cube(0,posy,1300,400, new Color(Color.YELLOW)));
		cubes.add(new Cube(posx, posy, 200, 400, new Color(Color.YELLOW)));
		

	}

}
