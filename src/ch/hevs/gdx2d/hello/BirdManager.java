package ch.hevs.gdx2d.hello;


import java.util.Vector;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.lib.GdxGraphics;

/**
 * this class generate random birds and make them move
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */

public class BirdManager {
	
	//Attributes
	Vector<Bird> birdes = new Vector<Bird>();

	// parameter of the random generator
	float dt;
	float speed = -4;
	float variablespeed = 3f;

	// position of the birds
	int posx = 1000;
	int posy = 0;

	/**
	 * generate random position of the birds
	 */
	void generateBird() {
		dt += Gdx.graphics.getDeltaTime();

		if (dt > variablespeed) {

			dt = 0;
			posx = (int) (Math.random() * 7000);
			if (posx < 800 || posx > 2500) {
				posx = 1000;
			}
			posy = (int) (Math.random() * 800);

			if (posy < 300 || posy > 700) {
				posy = 580;
			}

			birdes.add(new Bird(posx, posy));

		}

	}

	/**
	 * remove the birds when they are no longer visible
	 */
	void distroyBird() {
		if (birdes.get(0).posX < -100) {
			birdes.remove(0);
		}
	}

	/**
	 * movement of the birds and draw them
	 * @param g
	 */
	public void moveTotalBird(GdxGraphics g) {
		for (Bird b : birdes) {
			b.draw(g);
			b.moveBird();
		}
	}

	/**
	 * generate first birds
	 */
	public void generatefirstbird() {
		birdes.add(new Bird(1200, 300));
		birdes.add(new Bird(1800, 300));

	}

}
